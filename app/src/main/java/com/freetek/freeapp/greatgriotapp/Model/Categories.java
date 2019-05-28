package com.freetek.freeapp.greatgriotapp.Model;

public class Categories {
    private String imageUrl, name;

    public Categories(String image, String name){
        this.imageUrl = image;
        this.name = name;
    }

    public Categories(){

    }


    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String image) {
        this.imageUrl = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
