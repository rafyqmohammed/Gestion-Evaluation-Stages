package com.example.demo.repositories;

import com.example.demo.model.Periode;
import com.example.demo.model.PeriodeId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeriodeRepository extends JpaRepository<Periode, PeriodeId> {
}
