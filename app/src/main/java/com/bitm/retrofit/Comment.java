package com.bitm.retrofit;

public class Comment {

    private int postId;
    private int id;
    private String name;
    private String email;

    public Comment(int postId, int id, String name, String email) {
        this.postId = postId;
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public int getPostId() {
        return postId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
