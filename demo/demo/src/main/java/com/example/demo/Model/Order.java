package com.example.demo.Model;

import com.example.demo.Service.OrderState;
import com.example.demo.Service.OrderShipmentState;

import java.util.List;
import java.util.Random;

abstract public class Order {
    Random random = new Random();
    private OrderState Orderstate = new OrderState();
    private OrderShipmentState Ordershipmentstate = new OrderShipmentState();
    protected boolean orderState = Orderstate.OrderState();
    protected boolean orderShipmentState = Ordershipmentstate.OrderShipmentState();
    protected double Price;
    protected double Shipping = 100;
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
    public boolean getOrderShipmentState() {
        return orderShipmentState;
    }
    public void setOrderState(boolean t){orderState = t;}
    public void setOrderShipmentState(boolean t){orderShipmentState = t;}

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
    public double getShipping()
    {
        return Shipping;
    }
}
