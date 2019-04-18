package com.tactfactory.webposter.entities;

import com.tactfactory.webposter.database.base.DbEntity;

public class Post extends DbEntity {
    private String title;
    private String body;
    private Long userId;
    private User user;

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
        if (this.user != null){
            return this.user.getId();
        }else{
            return null;
        }
    }

    public void setUserId(Long userId) {
        if (this.user != null){
            this.user.setId(userId);
        }else{
            this.user = new User(userId);
        }
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
        super(postId);
    }

    public Post(Long id, String title, String body, Long userId, User user) {
        super(id);
        this.title = title;
        this.body = body;
        this.userId = userId;
        this.user = user;
    }
}
