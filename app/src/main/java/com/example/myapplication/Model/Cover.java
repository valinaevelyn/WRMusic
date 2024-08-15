package com.example.myapplication.Model;

public class Cover {
    private int imageResId;
    private String label;

    public Cover(int imageResId, String label) {
        this.imageResId = imageResId;
        this.label = label;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getLabel() {
        return label;
    }
}