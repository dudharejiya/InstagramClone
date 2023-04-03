package com.example.instagramclone;

public class CardItem {
    private String title;
    private int imageResource;

    public CardItem(String title, int imageResource) {
        this.title = title;
        this.imageResource = imageResource;
    }

    public String getTitle() {
        return title;
    }

    public int getImageResource() {
        return imageResource;
    }
}
