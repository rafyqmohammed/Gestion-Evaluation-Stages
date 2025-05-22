package com.example.demo.Dto;

import com.example.demo.model.AppreciationId;

import java.awt.desktop.AppReopenedEvent;

public class EvaluationDto {
    private String categorie;
    private String valeur;

    private AppreciationId appreciationId;

    public EvaluationDto() {
    }
    public EvaluationDto(String categorie, String valeur, AppreciationId appreciationId) {
        this.categorie = categorie;
        this.valeur = valeur;
        this.appreciationId = appreciationId;
    }
    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getValeur() {
        return valeur;
    }

    public void setValeur(String valeur) {
        this.valeur = valeur;
    }

    public AppreciationId getAppreciationId() {
        return appreciationId;
    }

    public void setAppreciationId(AppreciationId appreciationId) {
        this.appreciationId = appreciationId;
    }
    @Override
    public String toString() {
        return "EvaluationDto{" +
                "categorie='" + categorie + '\'' +
                ", valeur='" + valeur + '\'' +
                ", appreciationId=" + appreciationId +
                '}';
    }
}
