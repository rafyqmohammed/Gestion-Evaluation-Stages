package com.example.demo.controllers;

import com.example.demo.Dto.StageRequestDto;
import com.example.demo.model.*;
import com.example.demo.repositories.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
public class StageController {
    @Autowired
    private StageRepository stageRepository;
    @Autowired
    private EvaluationRepository evaluationRepository;
    @Autowired
    private PersonneRepository personneRepository;
    @Autowired
    private PeriodeRepository periodeRepository;
    @Autowired
    private AppreciationRepository appreciationRepository;
    @Autowired
    private CompetenceRepository competenceRepository;
    @Autowired
    private CategorieRepository categorieRepository;



    @PostMapping("/stage")
    public Appreciation createStage(@RequestBody StageRequestDto stagetDtO) {
        ModelMapper modelMapper = new ModelMapper();

        Stage stage = modelMapper.map(stagetDtO.getStage(), Stage.class);
        Personne tuteur = modelMapper.map(stagetDtO.getTuteur(), Tuteur.class);
        Personne stagiaire = modelMapper.map(stagetDtO.getStagiaire(), Stagiaire.class);
        Periode periode = modelMapper.map(stagetDtO.getPeriode(), Periode.class);
        // + de moi
        Appreciation appreciation = modelMapper.map(stagetDtO.getAppreciation(), Appreciation.class);
        Evaluation evaluation = modelMapper.map(stagetDtO.getEvaluation(), Evaluation.class);
       // Competence competence = modelMapper.map(stagetDtO.getCompetence(), Competence.class);
       // Categorie categorie = modelMapper.map(stagetDtO.getCategorie(), Categorie.class);



        Stage savedStage = stageRepository.save(stage);
        Stagiaire savedStagiaire = (Stagiaire) personneRepository.save(stagiaire);
        Tuteur savedTuteur = (Tuteur) personneRepository.save(tuteur);

        PeriodeId periodeId = new PeriodeId();
        periodeId.setStageId(savedStage.getId());
        periodeId.setStagiaireId(savedStagiaire.getId());

        periode.setPeriodeId(periodeId);
        periode.setStage(savedStage);
        periode.setStagiaire(savedStagiaire);
        Periode savedPeriode = periodeRepository.save(periode);

            // Après avoir sauvegardé la période
            AppreciationId appreciationId = new AppreciationId();
            appreciationId.setTuteurId(savedTuteur.getId());
            appreciationId.setPeriodeId(savedPeriode.getPeriodeId());

            appreciation.setAppreciationId(appreciationId);
            appreciation.setTuteur(savedTuteur);
            appreciation.setPeriode(savedPeriode);

            // Conversion et sauvegarde des évaluations
            List<Evaluation> evaluations = stagetDtO.getEvaluation().stream()
                    .map(evalDto -> {
                        Evaluation eval = modelMapper.map(evalDto, Evaluation.class);
                        eval.setAppreciation(appreciation);
                        return eval;
                    })
                    .collect(Collectors.toList());

            appreciation.setEvaluations(evaluations);

            // Conversion et sauvegarde des compétences avec leurs catégories
            List<Competence> competences = stagetDtO.getCompetences().stream()
                    .map(compDto -> {
                        Competence comp = modelMapper.map(compDto, Competence.class);
                        comp.setAppreciation(appreciation);

                        // Conversion des catégories pour chaque compétence
                        List<Categorie> categories = compDto.getCategories().stream()
                                .map(catDto -> {
                                    Categorie cat = modelMapper.map(catDto, Categorie.class);
                                    cat.setCompetence(comp);
                                    return cat;
                                })
                                .collect(Collectors.toList());

                        comp.setCategories(categories);
                        return comp;
                    })
                    .collect(Collectors.toList());

            appreciation.setCompetences(competences);

            // Sauvegarde dans l'ordre correct
            Appreciation savedAppreciation = appreciationRepository.save(appreciation);

            // Sauvegarde des compétences
            List<Competence> savedCompetences = competenceRepository.saveAll(competences);

            // Sauvegarde des catégories pour toutes les compétences
            List<Categorie> allCategories = competences.stream()
                    .flatMap(comp -> comp.getCategories().stream())
                    .collect(Collectors.toList());
            List<Categorie> savedCategories = categorieRepository.saveAll(allCategories);

            // Sauvegarde des évaluations
            List<Evaluation> savedEvaluations = evaluationRepository.saveAll(evaluations);

            return savedAppreciation;
        }
    @GetMapping("/jibliyastage")
    public List<Stage> getJibliyastage() {
        return stageRepository.findAll();
    }


}

