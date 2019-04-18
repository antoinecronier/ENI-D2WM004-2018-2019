package com.tactfactory.webposter.entities;

import com.tactfactory.webposter.database.base.DbEntity;

import java.io.Serializable;

public class Company implements DbEntity, Serializable {
    private Long id;
    private String name;
    private String catchPhrase;
    private String bs;

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCatchPhrase() {
        return catchPhrase;
    }

    public void setCatchPhrase(String catchPhrase) {
        this.catchPhrase = catchPhrase;
    }

    public String getBs() {
        return bs;
    }

    public void setBs(String bs) {
        this.bs = bs;
    }

    public Company() {
    }

    public Company(Long id, String name, String catchPhrase, String bs) {
        this.id = id;
        this.name = name;
        this.catchPhrase = catchPhrase;
        this.bs = bs;
    }
}
