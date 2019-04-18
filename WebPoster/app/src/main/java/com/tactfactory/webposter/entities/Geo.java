package com.tactfactory.webposter.entities;

import com.tactfactory.webposter.database.base.DbEntity;

public class Geo extends DbEntity {
    private Long lat;
    private Long lng;

    public Long getLat() {
        return lat;
    }

    public void setLat(Long lat) {
        this.lat = lat;
    }

    public Long getLng() {
        return lng;
    }

    public void setLng(Long lng) {
        this.lng = lng;
    }

    public Geo() {
    }

    public Geo(Long id, Long lat, Long lng) {
        super(id);
        this.lat = lat;
        this.lng = lng;
    }
}
