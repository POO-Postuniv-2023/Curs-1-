package com.ubb.postuniv.Domain;

public class Part {

    private int id;
    private String name;
    private float price;
    private int stock;
    private String type;

    public Part(int id, String name, float price, int stock, String type) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.type = type;
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Part{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", type='" + type + '\'' +
                '}';
    }
}
