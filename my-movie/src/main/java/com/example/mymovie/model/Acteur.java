package com.example.mymovie.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import io.swagger.annotations.ApiModelProperty;


public class Acteur
{
    @ApiModelProperty(notes = "Last Name of the Actor",name="nom",required=true,value="test last name")
    private String nom;
    @ApiModelProperty(notes = "First Name of the Actor",name="prenom",required=true,value="test first name")
    private String prenom;
    @ApiModelProperty(notes = "Filmography of the Actor",name="filmographie",required=true,value="test filmography")
    private Map<String, String> filmographie = new HashMap<String, String>();


    public Acteur(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public Acteur(String nom, String prenom, Film filmographie) {
        this.nom = nom;
        this.prenom = prenom;
        this.filmographie.put("titre",filmographie.getTitre());
        this.filmographie.put("realiseur",filmographie.getRealiseur() );
        this.filmographie.put("date",filmographie.getDate());
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Map<String, String> getFilmographie() {
        return filmographie;
    }

    public void setFilmographie(Film filmographie) {
        this.filmographie.put("titre",filmographie.getTitre());
        this.filmographie.put("realiseur",filmographie.getRealiseur() );
        this.filmographie.put("date",filmographie.getDate());;
    }



    @Override
    public String toString() {
        return "Acteur{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", filmographie=" + filmographie +
                '}';
    }
}
