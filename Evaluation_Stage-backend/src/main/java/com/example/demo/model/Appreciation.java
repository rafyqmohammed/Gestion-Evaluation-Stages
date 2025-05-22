package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "appreciation")
public class Appreciation {
    @EmbeddedId
    private AppreciationId appreciationId;
    private String commentaire;

    @JsonIgnore
    @ManyToOne
    @MapsId("tuteurId")
    private Tuteur tuteur;

    @JsonIgnore
    @ManyToOne
    @MapsId("periodeId")
    private Periode periode;

    @OneToMany(mappedBy = "appreciation")
    private List<Evaluation> evaluations;

    @OneToMany(mappedBy = "appreciation")
    private List<Competence> competences;

    public Appreciation() {
    }

    public AppreciationId getAppreciationId() {
        return appreciationId;
    }

    public void setAppreciationId(AppreciationId appreciationId) {
        this.appreciationId = appreciationId;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public Tuteur getTuteur() {
        return tuteur;
    }

    public void setTuteur(Tuteur tuteur) {
        this.tuteur = tuteur;
    }

    public Periode getPeriode() {
        return periode;
    }

    public void setPeriode(Periode periode) {
        this.periode = periode;
    }

    public List<Evaluation> getEvaluations() {
        return evaluations;
    }

    public void setEvaluations(List<Evaluation> evaluations) {
        this.evaluations = evaluations;
    }

    public List<Competence> getCompetences() {
        return competences;
    }

    public void setCompetences(List<Competence> competences) {
        this.competences = competences;
    }
}
