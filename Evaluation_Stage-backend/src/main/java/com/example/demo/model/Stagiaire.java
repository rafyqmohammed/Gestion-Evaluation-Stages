package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "stagiaire")

public class Stagiaire extends Personne {
    private String institution;

    //@JsonManagedReference
    @OneToMany(mappedBy = "stagiaire")
    private List<Periode> periodes;


    public Stagiaire() {

    }

    public Stagiaire(String institution) {
        this.institution = institution;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public List<Periode> getPeriodes() {
        return periodes;
    }

    public void setPeriodes(List<Periode> periodes) {
        this.periodes = periodes;
    }
}