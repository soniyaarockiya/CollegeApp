package com.example.a91user.collegeapp;

public class Product {

    int image;
    String title, Shortdescription ;

    public Product(int image, String title, String Shortdescription) {
        this.image = image;
        this.title = title;
        this.Shortdescription = Shortdescription;
    }

    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return Shortdescription;
    }
}
