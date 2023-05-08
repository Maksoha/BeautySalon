package ru.example.beautysalon.data.models;

import ru.example.beautysalon.R;

public class PhotoModel {

    private int imageResourceId;

    public PhotoModel(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }
}
