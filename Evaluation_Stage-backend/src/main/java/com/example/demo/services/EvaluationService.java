package com.example.demo.services;

import com.example.demo.Dto.EvaluationDto;
import com.example.demo.ExceptionPersonnalises.RessourceNotFoundException;
import com.example.demo.model.*;
import com.example.demo.repositories.AppreciationRepository;
import com.example.demo.repositories.EvaluationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EvaluationService {
    @Autowired
    private EvaluationRepository evaluationRepository;
    @Autowired
    private AppreciationRepository appreciationRepository;

    public Evaluation createEvaluation(EvaluationDto evaluationDto) {

        // Vérifier si la période existe
        Optional<Appreciation> appreciation = appreciationRepository.findById(evaluationDto.getAppreciationId());
        if (appreciation.isEmpty()) {
            throw new RessourceNotFoundException("Appreciation introuvable");
        }

        Evaluation evaluation = new Evaluation();
        evaluation.setCategorie(evaluationDto.getCategorie());
        evaluation.setValeur(evaluationDto.getValeur());
        evaluation.setAppreciation(appreciation.get());

        return evaluationRepository.save(evaluation);
    }
}