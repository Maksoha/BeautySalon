package ru.example.beautysalon.data.models;

public class ServiceModel {

    private String name, type;
    private int price;

    public ServiceModel(String type, String name, int price) {
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }
}
