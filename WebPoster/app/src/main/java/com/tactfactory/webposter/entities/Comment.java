package com.tactfactory.webposter.entities;

import com.tactfactory.webposter.database.base.DbEntity;
import com.tactfactory.webposter.views.adapters.UpdatableItem;
import com.tactfactory.webposter.webservice.WebServicable;

import java.io.Serializable;

public class Comment implements DbEntity, Serializable, WebServicable, UpdatableItem {
    private Long id;
    private String name;
    private String email;
    private String body;
    private Long postId;
    private Post post;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Long getPostId() {
        if (this.post != null){
            return this.post.getId();
        }else{
            return null;
        }
    }

    public void setPostId(Long postId) {
        if (this.post != null){
            this.post.setId(postId);
        }else{
            this.post = new Post(postId);
        }
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Comment() {
    }

    public Comment(Long id, String name, String email, String body, Long postId, Post post) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.body = body;
        this.postId = postId;
        this.post = post;
    }
}
