package com.example.demo.Model;

import com.example.demo.Service.OrderState;

import java.util.List;
import java.util.Random;

abstract public class Order {
    Random random = new Random();
    private OrderState Orderstate = new OrderState();
    protected boolean orderState = Orderstate.OrderState();
    protected double Price;
    protected List<Product> products;
    protected String username;
    protected int orderNumber  = random.nextInt(0,10000009);


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }



    public boolean getOrderState() {
        return orderState;
    }
    public void setOrderState(boolean t){orderState = t;}

    public List<Product> getProducts() {
        return products;
    }

    public int getOrderNumber() {
        return orderNumber;
    }
    public abstract List<Product> SelectProductsByNames(String username,List<String> productNames);
    public double getOrderPrice(){
        return Price;
    }
}
