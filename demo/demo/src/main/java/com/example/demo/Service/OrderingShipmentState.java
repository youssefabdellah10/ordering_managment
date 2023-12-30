package com.example.demo.Service;
import com.example.demo.Model.Order;

public interface OrderingShipmentState {
    public void shipmentState(Order order, String username, double price);
    boolean setshipmentState(boolean b);
}
