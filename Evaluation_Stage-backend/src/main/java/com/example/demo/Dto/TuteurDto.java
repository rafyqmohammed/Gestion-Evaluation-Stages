package com.example.demo.Dto;

public class TuteurDto extends PersonneDto {
    private String entreprise;

    public TuteurDto() {
    }
    public TuteurDto(String entreprise) {
        this.entreprise = entreprise;
    }
    public String getEntreprise() {
        return entreprise;
    }
    public void setEntreprise(String entreprise) {
        this.entreprise = entreprise;
    }

}
