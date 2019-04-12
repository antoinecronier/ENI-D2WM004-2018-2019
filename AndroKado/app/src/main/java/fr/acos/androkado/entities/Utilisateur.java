package fr.acos.androkado.entities;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

import fr.acos.androkado.database.base.DbEntity;

public class Utilisateur extends DbEntity implements Parcelable {
    private String nom;
    private String prenom;

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

    public Utilisateur(){

    }

    public Utilisateur(String nom, String prenom) {
        this.setNom(nom);
        this.setPrenom(prenom);
    }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                '}';
    }

    protected Utilisateur(Parcel in) {
        nom = in.readString();
        prenom = in.readString();
    }

    public static final Creator<Utilisateur> CREATOR = new Creator<Utilisateur>() {
        @Override
        public Utilisateur createFromParcel(Parcel in) {
            return new Utilisateur(in);
        }

        @Override
        public Utilisateur[] newArray(int size) {
            return new Utilisateur[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nom);
        dest.writeString(prenom);
    }
}
