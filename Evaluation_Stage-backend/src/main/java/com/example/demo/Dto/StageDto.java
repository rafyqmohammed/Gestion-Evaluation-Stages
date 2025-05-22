package com.example.demo.Dto;

public class StageDto {
    private String description;
    private String objectif;
    private String entreprise;

    public StageDto() {
    }
    public StageDto(String description, String objectif, String entreprise) {
        this.description = description;
        this.objectif = objectif;
        this.entreprise = entreprise;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getObjectif() {
        return objectif;
    }

    public void setObjectif(String objectif) {
        this.objectif = objectif;
    }

    public String getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(String entreprise) {
        this.entreprise = entreprise;
    }
}
