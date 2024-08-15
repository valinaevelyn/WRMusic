package com.example.myapplication.Model;

public class Album {
    private String title;
    private String artist;
    private String genre;
    private double rating;
    private int image;
    private double price;

    public Album(String title, String artist, String genre, double rating, int image, double price) {
        this.title = title;
        this.artist = artist;
        this.genre = genre;
        this.rating = rating;
        this.image = image;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getGenre() {
        return genre;
    }

    public double getRating() {
        return rating;
    }

    public int getImage() {
        return image;
    }

    public double getPrice() {
        return price;
    }
}