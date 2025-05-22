package com.example.demo.model;


import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;


@Entity
@Table(name = "tuteur")

public class Tuteur extends Personne {
    private String entreprise;

    @OneToMany(mappedBy = "tuteur")
    private List<Appreciation> appreciations;


    public Tuteur() {

    }

    public String getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(String entreprise) {
        this.entreprise = entreprise;
    }

    public List<Appreciation> getAppreciations() {
        return appreciations;
    }

    public void setAppreciations(List<Appreciation> appreciations) {
        this.appreciations = appreciations;
    }
}