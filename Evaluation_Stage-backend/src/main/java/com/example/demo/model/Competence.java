package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "competence")
public class Competence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String intitule;
    private double note;

    @JsonIgnore
    @ManyToOne
    //@MapsId("appreciationId")
    @JoinColumns({
            @JoinColumn(name = "periode_stagiaire_id", referencedColumnName = "periode_stagiaire_id"),
            @JoinColumn(name = "periode_stage_id", referencedColumnName = "periode_stage_id"),
            @JoinColumn(name = "tuteur_id", referencedColumnName = "tuteur_id")
    })
    private Appreciation appreciation;

    @OneToMany(mappedBy = "competence")
    private List<Categorie> categories;

    public Competence() {
    }

    public Competence(String intitule, double note) {
        this.intitule = intitule;
        this.note = note;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public Appreciation getAppreciation() {
        return appreciation;
    }

    public void setAppreciation(Appreciation appreciation) {
        this.appreciation = appreciation;
    }

    public double getNote() {
        return note;
    }

    public void setNote(double note) {
        this.note = note;
    }

    public List<Categorie> getCategories() {
        return categories;
    }

    public void setCategories(List<Categorie> categories) {
        this.categories = categories;
    }
}
