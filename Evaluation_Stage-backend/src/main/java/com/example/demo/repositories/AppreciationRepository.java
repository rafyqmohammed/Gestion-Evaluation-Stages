package com.example.demo.repositories;

import com.example.demo.model.Appreciation;
import com.example.demo.model.AppreciationId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppreciationRepository extends JpaRepository<Appreciation, AppreciationId> {
    // Custom query methods can be defined here if needed
}
