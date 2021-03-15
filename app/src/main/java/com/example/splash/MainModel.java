package com.example.splash;

public class MainModel {
    int image;
    String name, price, desc;

    public MainModel(int image, String name, String price, String desc) {
        this.image = image;
        this.name = name;
        this.price = price;
        this.desc = desc;
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getDesc() {
        return desc;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
