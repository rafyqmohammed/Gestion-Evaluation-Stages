package com.example.demo.controllers;

import com.example.demo.model.Periode;
import com.example.demo.model.Personne;
import com.example.demo.model.Stage;
import com.example.demo.model.Stagiaire;
import com.example.demo.repositories.PeriodeRepository;
import com.example.demo.repositories.PersonneRepository;
import com.example.demo.repositories.StageRepository;
import com.example.demo.services.PeriodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/periode")
public class PeriodeController {

    @Autowired
    private PeriodeService periodeService;

    @PostMapping()
    public Periode addPeriode(@RequestBody Periode periode) {

        return periodeService.createPeriode(periode);
    }
}
