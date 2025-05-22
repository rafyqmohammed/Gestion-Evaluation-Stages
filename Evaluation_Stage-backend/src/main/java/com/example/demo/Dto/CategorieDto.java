package com.example.demo.Dto;

public class CategorieDto {
    private String intitule;
    private String valeur;

    public CategorieDto(String intitule, String valeur) {
        this.intitule = intitule;
        this.valeur = valeur;
    }
    public CategorieDto() {
    }
    public String getIntitule() {
        return intitule;
    }
    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }
    public String getValeur() {
        return valeur;
    }
    public void setValeur(String valeur) {
        this.valeur = valeur;
    }
}
