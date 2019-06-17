package com.tactfactory.vroom.entities;

import java.io.Serializable;
import java.time.LocalDate;

public class Voiture implements Serializable {

    private Long id;

    private Integer nbRoue;
    private String plaque;
    private String couleur;
    private String marque;
    private LocalDate dateDeMiseEnCirculation;
    private String nom;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNbRoue() {
        return nbRoue;
    }

    public void setNbRoue(Integer nbRoue) {
        this.nbRoue = nbRoue;
    }

    public String getPlaque() {
        return plaque;
    }

    public void setPlaque(String plaque) {
        this.plaque = plaque;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public LocalDate getDateDeMiseEnCirculation() {
        return dateDeMiseEnCirculation;
    }

    public void setDateDeMiseEnCirculation(LocalDate dateDeMiseEnCirculation) {
        this.dateDeMiseEnCirculation = dateDeMiseEnCirculation;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Voiture() {

    }

    public Voiture(Integer nbRoue, String plaque, String couleur, String marque, LocalDate dateDeMiseEnCirculation, String nom) {
        this.nbRoue = nbRoue;
        this.plaque = plaque;
        this.couleur = couleur;
        this.marque = marque;
        this.dateDeMiseEnCirculation = dateDeMiseEnCirculation;
        this.nom = nom;
    }

    public Voiture(Long id, Integer nbRoue, String plaque, String couleur, String marque, LocalDate dateDeMiseEnCirculation, String nom) {
        this.id = id;
        this.nbRoue = nbRoue;
        this.plaque = plaque;
        this.couleur = couleur;
        this.marque = marque;
        this.dateDeMiseEnCirculation = dateDeMiseEnCirculation;
        this.nom = nom;
    }
}
