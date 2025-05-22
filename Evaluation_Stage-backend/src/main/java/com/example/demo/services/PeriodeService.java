package com.example.demo.services;

import com.example.demo.ExceptionPersonnalises.RessourceNotFoundException;
import com.example.demo.model.Periode;
import com.example.demo.model.Personne;
import com.example.demo.model.Stage;
import com.example.demo.model.Stagiaire;
import com.example.demo.repositories.PeriodeRepository;
import com.example.demo.repositories.PersonneRepository;
import com.example.demo.repositories.StageRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PeriodeService {
    @Autowired
    private PersonneRepository personneRepository;
    @Autowired
    private PeriodeRepository periodeRepository;
    @Autowired
    private StageRepository stageRepository;

    public Periode createPeriode(Periode periode) {
        // Récupérer le stagiaire
        Optional<Personne> personne = personneRepository.findById(periode.getPeriodeId().getStagiaireId());
        if (personne.isEmpty() || !(personne.get() instanceof Stagiaire)) {
           throw new RessourceNotFoundException("Stagiaire introuvable ou type incorrect");
        }
        Stagiaire stagiaire = (Stagiaire) personne.get();
        periode.setStagiaire(stagiaire);

        // Récupérer le stage
        Optional<Stage> stage = stageRepository.findById(periode.getPeriodeId().getStageId());
        if (stage.isEmpty()) {
            throw new RessourceNotFoundException("Stage introuvable");
        }
        periode.setStage(stage.get());

        // Sauvegarder la période
        return periodeRepository.save(periode);
    }


}
