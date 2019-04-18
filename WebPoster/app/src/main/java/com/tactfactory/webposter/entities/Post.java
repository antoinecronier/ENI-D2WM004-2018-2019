package com.tactfactory.webposter.entities;

import com.tactfactory.webposter.database.base.DbEntity;
import com.tactfactory.webposter.views.adapters.UpdatableItem;
import com.tactfactory.webposter.webservice.WebServicable;

import java.io.Serializable;

public class Post implements DbEntity, Serializable, WebServicable, UpdatableItem {
    private Long id;
    private String title;
    private String body;
    private Long userId;
    private User user;

    @Override
    public Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(Long userId) {
        if (this.user != null){
            this.user.setId(userId);
        }else{
            this.user = new User(userId);
        }
        this.userId = userId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post() {
    }

    public Post(Long postId) {
        this.id = postId;
    }

    public Post(Long id, String title, String body, Long userId, User user) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.userId = userId;
        this.user = user;
    }
}
