package com.example.demo.Dto;

public class AppreciationDto {
    private String commentaire;

    public AppreciationDto() {

    }
    public AppreciationDto(String commentaire) {
        this.commentaire = commentaire;
    }
    public String getCommentaire() {
        return commentaire;
    }
    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }
}
