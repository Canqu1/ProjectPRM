package com.example.myapplication.Entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class Category implements Serializable {
    @PrimaryKey(autoGenerate = true)
    public int catId;
    public String title;
    public String  pic ;
    public Category(String title, String pic) {
        this.title = title;
        this.pic = pic;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }
}
