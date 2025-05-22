package com.example.demo.controllers;

import com.example.demo.model.Appreciation;
import com.example.demo.repositories.AppreciationRepository;
import com.example.demo.services.AppreciationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appreciation")
public class AppreciationController {
    @Autowired
    private AppreciationService appreciationService;
    @Autowired
    private AppreciationRepository appreciationRepository;

    @GetMapping
    public List<Appreciation> getAllAppreciation(){
        return  appreciationRepository.findAll();
    }
    @PostMapping
    public Appreciation addAppreciation(@RequestBody Appreciation appreciation) {
        return appreciationService.createAppreciation(appreciation);
    }


}
