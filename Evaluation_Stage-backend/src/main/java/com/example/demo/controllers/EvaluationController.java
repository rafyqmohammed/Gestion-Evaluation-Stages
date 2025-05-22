package com.example.demo.controllers;

import com.example.demo.Dto.EvaluationDto;
import com.example.demo.model.Evaluation;
import com.example.demo.repositories.EvaluationRepository;
import com.example.demo.services.EvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/evaluation")
public class EvaluationController {

    @Autowired
    private EvaluationService evaluationService;
    @Autowired
    private EvaluationRepository evaluationRepository;
    @PostMapping
    public Evaluation addEvaluation(@RequestBody EvaluationDto evaluationDto) {
        System.out.println(evaluationDto);
        return evaluationService.createEvaluation(evaluationDto);
    }
    @PostMapping("ajEval")
    public List<Evaluation> addEvaluation2(@RequestBody List<Evaluation> evaluations) {
            return evaluationRepository.saveAll(evaluations);
    }
}
