package com.freetek.freeapp.greatgriotapp.Model;

public class EbookListByCategoriesModel {

    private String author;
    private String category;
    private String chapters;
    private String image;
    private String name;
    private String pages;
    private String publisher;
    private String rating;
    private String year;


    public EbookListByCategoriesModel(){

    }

    public EbookListByCategoriesModel(String author, String category, String chapters, String image, String name, String pages, String publisher, String rating, String year) {
        this.author = author;
        this.category = category;
        this.chapters = chapters;
        this.image = image;
        this.name = name;
        this.pages = pages;
        this.publisher = publisher;
        this.rating = rating;
        this.year = year;
    }




    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getChapters() {
        return chapters;
    }

    public void setChapters(String chapters) {
        this.chapters = chapters;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }





}
