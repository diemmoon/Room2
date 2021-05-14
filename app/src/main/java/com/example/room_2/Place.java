package com.example.room_2;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Place {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;

    public Place(int id, String place) {
        this.id = id;
        this.name = place;
    }

    public Place() {
    }

    public Place(String place) {
        this.name = place;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
