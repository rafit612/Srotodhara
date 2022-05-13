package com.example.ecommerce;

public class cosmeticModelClass {
    String Brand,Capacity,Description,PID,Price,Title;

    public cosmeticModelClass() {
    }

    public cosmeticModelClass(String brand, String capacity, String description, String PID, String price, String title) {
        Brand = brand;
        Capacity = capacity;
        Description = description;
        this.PID = PID;
        Price = price;
        Title = title;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }

    public String getCapacity() {
        return Capacity;
    }

    public void setCapacity(String capacity) {
        Capacity = capacity;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getPID() {
        return PID;
    }

    public void setPID(String PID) {
        this.PID = PID;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }
}
