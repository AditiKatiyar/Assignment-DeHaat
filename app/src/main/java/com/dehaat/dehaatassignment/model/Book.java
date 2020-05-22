package com.dehaat.dehaatassignment.model;

public class Book {

    private String title;
    private String description;
    private String publisher;
    private String publishedDate;
    private String price;

    public Book(String title, String description, String publisher, String publishedDate, String price){
        this.title = title;
        this.description = description;
        this.publisher = publisher;
        this.publishedDate = publishedDate;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
