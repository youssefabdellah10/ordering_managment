package com.example.demo.Model;

public class Product {
    private String serialNumber;
    private String name;
    private String vendor;
    private String category;
    private double price;
    private int quantity;
    public String getSerialNumber(){ return serialNumber; }
    public void setSerialNumber(String serialNumber){ this.serialNumber = serialNumber; }
    public String getName(){ return name; }
    public void setName(String name){ this.name = name; }
    public String getVendor(){ return vendor; }
    public void setVendor(String vendor){ this.vendor = vendor; }
    public String getCategory(){ return category; }
    public void setCategory(String category){ this.category = category; }
    public double getPrice(){ return price; }
    public void setPrice(double price){ this.price = price; }
    public int getQuantity(){ return quantity; }
    public void setQuantity(int quantity){ this.quantity = quantity; }
}
