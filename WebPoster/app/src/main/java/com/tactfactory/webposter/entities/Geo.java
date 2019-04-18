package com.tactfactory.webposter.entities;

import com.tactfactory.webposter.database.base.DbEntity;

import java.io.Serializable;

public class Geo implements DbEntity, Serializable {
    private Long id;
    private Double lat;
    private Double lng;

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public Geo() {
    }

    public Geo(Long id, Double lat, Double lng) {
        this.id = id;
        this.lat = lat;
        this.lng = lng;
    }
}
