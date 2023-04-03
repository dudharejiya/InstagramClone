package com.example.instagramclone;

public class CardViewItem {
    private String title;
    private String imageUrl;
    public CardViewItem(String title, String imageUrl) {
        this.title = title;
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
