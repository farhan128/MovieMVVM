package com.demo.moviemvvm.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tbl_movie")
public class Movie {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String name;

    private String description;

    private int posterID;

    private String tgl_rilis;

    public Movie(String name, String description, int posterID, String tgl_rilis) {
        this.name = name;
        this.description = description;
        this.posterID = posterID;
        this.tgl_rilis = tgl_rilis;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPosterID() {
        return posterID;
    }

    public void setPosterID(int posterID) {
        this.posterID = posterID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTgl_rilis() {
        return tgl_rilis;
    }

    public void setTgl_rilis(String tgl_rilis) {
        this.tgl_rilis = tgl_rilis;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}