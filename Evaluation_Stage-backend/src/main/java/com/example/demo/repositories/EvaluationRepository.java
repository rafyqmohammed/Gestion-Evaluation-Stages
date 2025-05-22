package com.example.demo.repositories;

import com.example.demo.model.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvaluationRepository extends JpaRepository<Evaluation, Long> {
    // Custom query methods can be defined here if needed
}
