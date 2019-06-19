package com.tactfactory.vroom.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.Relation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity(tableName = "garagiste")
public class Garagiste implements Serializable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "idGaragiste")
    private Long id;
    private String firstname;
    private String lastname;
    private String address;
    private String garageName;
    private String telNumber;

    //@Relation(parentColumn = "id", entityColumn = "garagisteId", entity = Garagiste.class)
    @Ignore
    private List<Voiture> voitures;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGarageName() {
        return garageName;
    }

    public void setGarageName(String garageName) {
        this.garageName = garageName;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public List<Voiture> getVoitures() {
        return voitures;
    }

    public void setVoitures(List<Voiture> voitures) {
        this.voitures = voitures;
    }

    public Garagiste() {
        this.voitures = new ArrayList<Voiture>();
    }

    @Ignore
    public Garagiste(String firstname, String lastname, String address, String garageName, String telNumber) {
        this();
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.garageName = garageName;
        this.telNumber = telNumber;
    }

    @Ignore
    public Garagiste(Long id, String firstname, String lastname, String address, String garageName, String telNumber, List<Voiture> voitures) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.garageName = garageName;
        this.telNumber = telNumber;
        this.voitures = voitures;
    }
}
