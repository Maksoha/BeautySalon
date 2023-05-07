package ru.example.beautysalon.data.models;

import ru.example.beautysalon.R;

public class PhotoModel {

    private int photoId = R.drawable.haircut;

    public PhotoModel(int photoId) {
        this.photoId = photoId;
    }

    public int getPhotoId() {
        return photoId;
    }

    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }
}
