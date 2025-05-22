package com.example.demo.Dto;

import java.util.List;

public class CompetenceDto {
    private String intitule;
    private double note;

    private List<CategorieDto> categories;

    public CompetenceDto() {
    }
    public CompetenceDto(String intitule, double note) {
        this.intitule = intitule;
        this.note = note;
    }
    public String getIntitule() {
        return intitule;
    }
    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }
    public double getNote() {
        return note;
    }
    public void setNote(double note) {
        this.note = note;
    }

    public List<CategorieDto> getCategories() {
        return categories;
    }

    public void setCategories(List<CategorieDto> categories) {
        this.categories = categories;
    }
}
