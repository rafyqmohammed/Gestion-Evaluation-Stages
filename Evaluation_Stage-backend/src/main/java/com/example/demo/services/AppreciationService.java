package com.example.demo.services;

import com.example.demo.ExceptionPersonnalises.RessourceNotFoundException;
import com.example.demo.model.Appreciation;
import com.example.demo.model.Periode;
import com.example.demo.model.Personne;
import com.example.demo.model.Tuteur;
import com.example.demo.repositories.AppreciationRepository;
import com.example.demo.repositories.PeriodeRepository;
import com.example.demo.repositories.PersonneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppreciationService {
    @Autowired
    private AppreciationRepository appreciationRepository;
    @Autowired
    private PeriodeRepository periodeRepository;
    @Autowired
    private PersonneRepository personneRepository;

    public Appreciation createAppreciation(Appreciation appreciation) {
        // Vérifier si la période existe
        Optional<Periode> periode = periodeRepository.findById(appreciation.getAppreciationId().getPeriodeId());
        if (periode.isEmpty()) {
            throw new RessourceNotFoundException("Période introuvable");
        }
        appreciation.setPeriode(periode.get());

        // Vérifier si le tuteur existe
        Optional<Personne> personne = personneRepository.findById(appreciation.getAppreciationId().getTuteurId());
        if (personne.isEmpty() || !(personne.get() instanceof Tuteur)) {
            throw new RessourceNotFoundException("Tuteur introuvable ou type incorrect");
        }
        Tuteur tuteur = (Tuteur) personne.get();
        appreciation.setTuteur(tuteur);

        // Sauvegarder l'appréciation
        return appreciationRepository.save(appreciation);
    }

}
