package com.example.myapplication.Model;

public class Item {
    private int id;
    private String name;
    private String artist;
    private String description;
    private int image;

    // Constructor + Getter Setter -> ALT + INSERT

    public Item(){

    }

    public Item(int id, String name, String artist, String description, int image) {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.description = description;
        this.image = image;
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

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
