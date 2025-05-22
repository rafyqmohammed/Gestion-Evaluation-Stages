package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "evaluation")
public class Evaluation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Categorie;
    private String valeur;

    @JsonIgnore
    @ManyToOne
    //@MapsId("appreciationId")
    //@JoinColumns(name = "appreciation_id")
    @JoinColumns({
            @JoinColumn(name = "periode_stagiaire_id", referencedColumnName = "periode_stagiaire_id"),
            @JoinColumn(name = "periode_stage_id", referencedColumnName = "periode_stage_id"),
            @JoinColumn(name = "tuteur_id", referencedColumnName = "tuteur_id")
    })
    private Appreciation appreciation;

    public Evaluation() {
    }

    public Evaluation(Long id, String categorie, String valeur, Appreciation appreciation) {
        this.id = id;
        Categorie = categorie;
        this.valeur = valeur;
        this.appreciation = appreciation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategorie() {
        return Categorie;
    }

    public void setCategorie(String categorie) {
        Categorie = categorie;
    }

    public String getValeur() {
        return valeur;
    }

    public void setValeur(String valeur) {
        this.valeur = valeur;
    }

    public Appreciation getAppreciation() {
        return appreciation;
    }

    public void setAppreciation(Appreciation appreciation) {
        this.appreciation = appreciation;
    }

    @Override
    public String toString() {
        return "Evaluation{" +
                "id=" + id +
                ", Categorie='" + Categorie + '\'' +
                ", valeur='" + valeur + '\'' +
                ", appreciation=" + appreciation +
                '}';
    }
}
