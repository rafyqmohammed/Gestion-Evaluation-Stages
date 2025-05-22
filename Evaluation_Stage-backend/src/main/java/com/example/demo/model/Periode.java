package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "periode")
public class Periode {
    @EmbeddedId
    private PeriodeId periodeId;

    private LocalDate db;
    private LocalDate df;

    //@JsonBackReference
    @JsonIgnore
    @ManyToOne
    @MapsId("stagiaireId") // Lie stagiaireId de PeriodeId à la clé étrangère de Stagiaire
    private Stagiaire stagiaire;

    //@JsonBackReference
    @JsonIgnore
    @ManyToOne
    @MapsId("stageId") // Lie stageId de PeriodeId à la clé étrangère de Stage
    private Stage stage;

    @OneToMany(mappedBy = "periode")
    private List<Appreciation> appreciations;


    public Periode() {
    }

    public Periode(PeriodeId periodeId, LocalDate db, LocalDate df) {
        this.periodeId = periodeId;
        this.db = db;
        this.df = df;
    }

    public Periode(PeriodeId periodeId, LocalDate db, LocalDate df, Stagiaire stagiaire, Stage stage) {
        this.periodeId = periodeId;
        this.db = db;
        this.df = df;
        this.stagiaire = stagiaire;
        this.stage = stage;
    }

    public PeriodeId getPeriodeId() {
        return periodeId;
    }

    public void setPeriodeId(PeriodeId periodeId) {
        this.periodeId = periodeId;
    }

    public LocalDate getDb() {
        return db;
    }

    public void setDb(LocalDate db) {
        this.db = db;
    }

    public LocalDate getDf() {
        return df;
    }

    public void setDf(LocalDate df) {
        this.df = df;
    }

    public Stagiaire getStagiaire() {
        return stagiaire;
    }

    public void setStagiaire(Stagiaire stagiaire) {
        this.stagiaire = stagiaire;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public List<Appreciation> getAppreciations() {
        return appreciations;
    }

    public void setAppreciations(List<Appreciation> appreciations) {
        this.appreciations = appreciations;
    }
}