package com.example.mymovie.model;

import io.swagger.annotations.ApiModelProperty;

public class Film
{
    @ApiModelProperty(notes = "Title of the Film",name="titre",required=true,value="test title")
    private String titre;
    @ApiModelProperty(notes = "Director of the Film",name="realiseur",required=true,value="test director")

    private String realiseur;
    @ApiModelProperty(notes = "Main Actor of the Film",name="acteur",required=true,value="test actor")

    private Acteur acteur;
    @ApiModelProperty(notes = "Release Year of the Film",name="date",required=true,value="test director")

    private String date;

    public Film(String titre, String realiseur, Acteur acteur, String dateDeSortie) {
        this.titre = titre;
        this.realiseur = realiseur;
        this.acteur = acteur;
        this.date = dateDeSortie;
        acteur.setFilmographie(this);
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getRealiseur() {
        return realiseur;
    }

    public void setRealiseur(String realiseur) {
        this.realiseur = realiseur;
    }

    public Acteur getActeur() {
        return acteur;
    }

    public void setActeur(Acteur acteur) {
        this.acteur = acteur;
    }

    public String getDate() {
        return date;
    }

    public void setDateDeSortie(String dateDeSortie) {
        this.date = dateDeSortie;
    }

    @Override
    public String toString() {
        return "Film{" +
                "titre='" + titre + '\'' +
                ", realiseur='" + realiseur + '\'' +
                ", acteur=" + acteur +
                ", dateDeSortie='" + date + '\'' +
                '}';
    }
}
