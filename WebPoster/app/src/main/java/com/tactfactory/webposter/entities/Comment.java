package com.tactfactory.webposter.entities;

import com.tactfactory.webposter.database.base.DbEntity;

public class Comment extends DbEntity {
    private String name;
    private String email;
    private String body;
    private Long postId;
    private Post post;

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
        super(id);
        this.name = name;
        this.email = email;
        this.body = body;
        this.postId = postId;
        this.post = post;
    }
}
