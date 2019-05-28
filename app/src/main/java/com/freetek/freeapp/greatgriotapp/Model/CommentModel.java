package com.freetek.freeapp.greatgriotapp.Model;

public class CommentModel {


    private String user, comment;


    public CommentModel(String user, String comment) {
        this.user = user;
        this.comment = comment;
    }


    public  CommentModel(){

    }


    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }


}
