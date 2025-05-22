package com.example.demo.Dto;

public class StagiaireDto extends PersonneDto {
    private String institution;

    public StagiaireDto() {

    }
    public StagiaireDto(String institution) {
        this.institution = institution;
    }
    public String getInstitution() {
        return institution;
    }
    public void setInstitution(String institution) {
        this.institution = institution;
    }

}
