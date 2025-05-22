package com.example.demo.controllers;

import com.example.demo.model.Personne;
import com.example.demo.model.Stagiaire;
import com.example.demo.model.Tuteur;
import com.example.demo.repositories.PersonneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonneController {

    @Autowired
    private PersonneRepository personneRepository;

    @PostMapping("/")
    public Personne addPersonne(@RequestBody Tuteur tuteur){
        return personneRepository.save(tuteur);
    }
    @PostMapping("/stagiaire")
    public Personne addStagiaire(@RequestBody Stagiaire stagiaire) {
        return personneRepository.save(stagiaire);
    }

    @PostMapping("/tuteur")
    public Personne addStagiaire(@RequestBody Tuteur tuteur) {
        return personneRepository.save(tuteur);
    }



}
