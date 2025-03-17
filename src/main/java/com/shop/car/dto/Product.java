package com.shop.car.dto;

import java.time.LocalDateTime;

public class Product {
    private int id,horsepower,max_Speed;
    private String brand,model,image_Url;
    private double price;
    private LocalDateTime create_Date;

    public Product() {
        super();
    }


    public Product(int id, String brand, String model, double price, int horsepower, int maxSpeed, String imageUrl, LocalDateTime createDate) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.horsepower = horsepower;
        this.max_Speed = maxSpeed;
        this.image_Url = imageUrl;
        this.create_Date = createDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    public int getMaxSpeed() {
        return max_Speed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.max_Speed = maxSpeed;
    }

    public String getImageUrl() {
        return image_Url;
    }

    public void setImageUrl(String imageUrl) {
        this.image_Url = imageUrl;
    }

    public LocalDateTime getCreateDate() {
        return create_Date;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.create_Date = createDate;
    }


    @Override
    public String toString() {
        return "Product [id=" + id + ", brand=" + brand + ", model=" + model + ", price=" + price 
            + ", horsepower=" + horsepower + ", maxSpeed=" + max_Speed + ", imageUrl=" + image_Url 
            + ", createDate=" + create_Date + "]";
    }
}
