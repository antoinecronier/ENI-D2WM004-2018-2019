package com.tactfactory.vroom.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;
import java.time.LocalDate;

@Entity(tableName = "voiture")
public class Voiture implements Serializable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private Long id;

    @ColumnInfo(name = "nb_roue")
    private Integer nbRoue;
    private String plaque;
    private String couleur;
    private String marque;

    @Ignore
    private LocalDate dateDeMiseEnCirculation;
    private String nom;

    @Ignore
    private Garagiste garagiste;

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

    public Garagiste getGaragiste() {
        return garagiste;
    }

    public void setGaragiste(Garagiste garagiste) {
        this.garagiste = garagiste;
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

    public Voiture(Integer nbRoue, String plaque, String couleur, String marque, LocalDate dateDeMiseEnCirculation, String nom, Garagiste garagiste) {
        this.nbRoue = nbRoue;
        this.plaque = plaque;
        this.couleur = couleur;
        this.marque = marque;
        this.dateDeMiseEnCirculation = dateDeMiseEnCirculation;
        this.nom = nom;
        this.garagiste = garagiste;
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

    public Voiture(Long id, Integer nbRoue, String plaque, String couleur, String marque, LocalDate dateDeMiseEnCirculation, String nom, Garagiste garagiste) {
        this.id = id;
        this.nbRoue = nbRoue;
        this.plaque = plaque;
        this.couleur = couleur;
        this.marque = marque;
        this.dateDeMiseEnCirculation = dateDeMiseEnCirculation;
        this.nom = nom;
        this.garagiste = garagiste;
    }
}
