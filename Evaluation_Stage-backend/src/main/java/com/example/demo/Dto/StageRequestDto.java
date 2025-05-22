package com.example.demo.Dto;

import java.util.List;

public class StageRequestDto {
    private StageDto stage;
    private TuteurDto tuteur;
    private StagiaireDto stagiaire;
    private List<EvaluationDto> evaluation;
    private PeriodeDto periode;
    private AppreciationDto appreciation;
    private List<CompetenceDto> competences;
    //private CategorieDto categorie;


    public StageRequestDto(StageDto stage, TuteurDto tuteur, StagiaireDto stagiaire, List<EvaluationDto> evaluation, PeriodeDto periode, AppreciationDto appreciation, List<CompetenceDto> competences) {
        this.stage = stage;
        this.tuteur = tuteur;
        this.stagiaire = stagiaire;
        this.evaluation = evaluation;
        this.periode = periode;
        this.appreciation = appreciation;
        this.competences = competences;
       // this.categorie = categorie;
    }
    public StageRequestDto() {
    }

    public StageDto getStage() {
        return stage;
    }

    public void setStage(StageDto stage) {
        this.stage = stage;
    }

    public TuteurDto getTuteur() {
        return tuteur;
    }

    public void setTuteur(TuteurDto tuteur) {
        this.tuteur = tuteur;
    }

    public StagiaireDto getStagiaire() {
        return stagiaire;
    }

    public void setStagiaire(StagiaireDto stagiaire) {
        this.stagiaire = stagiaire;
    }


    public List<EvaluationDto> getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(List<EvaluationDto> evaluation) {
        this.evaluation = evaluation;
    }

    public PeriodeDto getPeriode() {
        return periode;
    }

    public void setPeriode(PeriodeDto periode) {
        this.periode = periode;
    }

    public AppreciationDto getAppreciation() {
        return appreciation;
    }

    public void setAppreciation(AppreciationDto appreciation) {
        this.appreciation = appreciation;
    }
    public List<CompetenceDto> getCompetences() {
        return competences;
    }

    public void setCompetences(List<CompetenceDto> competences) {
        this.competences = competences;
    }

//    public CompetenceDto getCompetence() {
//        return competence;
//    }
//
//    public void setCompetence(CompetenceDto competence) {
//        this.competence = competence;
//    }
//
//    public CategorieDto getCategorie() {
//        return categorie;
//    }
//
//    public void setCategorie(CategorieDto categorie) {
//        this.categorie = categorie;
//    }
}
