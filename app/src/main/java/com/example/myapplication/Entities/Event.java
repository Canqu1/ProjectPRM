package com.example.myapplication.Entities;

public class Event {
    public int id;
    private String title;
    private String img;
    private String description;

    public Event() {
    }

    public Event( String title, String img, String description) {
        this.title = title;
        this.img = img;
        this.description = description;
    }



    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getImg() {
        return img;
    }

    public String getDescription() {
        return description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
