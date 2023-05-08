package ru.example.beautysalon.data.models;

public class ServiceImageModel extends ServiceModel{
    private int imageResourceId;

    public ServiceImageModel(String type, String name, int price, int imageResourceId) {
        super(type, name, price);
        this.imageResourceId = imageResourceId;
    }

    public ServiceImageModel(ServiceModel serviceModel, int imageResourceId) {
        super(serviceModel.getType(), serviceModel.getName(), serviceModel.getPrice());
        this.imageResourceId = imageResourceId;
    }

    public ServiceImageModel(String type, String name, int price) {
        super(type, name, price);
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }
}
