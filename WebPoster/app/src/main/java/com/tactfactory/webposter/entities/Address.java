package com.tactfactory.webposter.entities;

import com.tactfactory.webposter.database.base.DbEntity;

import java.io.Serializable;

public class Address implements DbEntity, Serializable {
    private Long id;
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private Geo geo;

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getSuite() {
        return suite;
    }

    public void setSuite(String suite) {
        this.suite = suite;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public Geo getGeo() {
        return geo;
    }

    public void setGeo(Geo geo) {
        this.geo = geo;
    }

    public Address() {
    }

    public Address(Long id, String street, String suite, String city, String zipcode, Geo geo) {
        this.id = id;
        this.street = street;
        this.suite = suite;
        this.city = city;
        this.zipcode = zipcode;
        this.geo = geo;
    }
}
