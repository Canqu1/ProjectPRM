package com.example.myapplication.model;

import java.io.Serializable;

public class Room implements Serializable {
    private String title;
    private String img;
    private String description;
    private double fee;

    public Room() {
    }

    public Room(String title, String img, String description, double fee) {
        this.title = title;
        this.img = img;
        this.description = description;
        this.fee = fee;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }
}
