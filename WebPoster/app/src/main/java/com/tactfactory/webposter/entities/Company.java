package com.tactfactory.webposter.entities;

import com.tactfactory.webposter.database.base.DbEntity;

public class Company extends DbEntity {
    private String name;
    private String catchPhrase;
    private String bs;

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
        super(id);
        this.name = name;
        this.catchPhrase = catchPhrase;
        this.bs = bs;
    }
}
