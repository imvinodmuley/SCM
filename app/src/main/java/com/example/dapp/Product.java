package com.example.dapp;

public class Product {
    private String id;
    private String title;


    public Product(String id,String title) {
        this.id=id;
        this.title = title;

    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }


}