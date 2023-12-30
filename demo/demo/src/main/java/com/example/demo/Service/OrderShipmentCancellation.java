package com.example.demo.Service;
import com.example.demo.Model.CustomerAccount;
import com.example.demo.Model.Order;
public class OrderShipmentCancellation implements OrderingShipmentState {
    int shipmentVal = 100;
    private boolean ordershipmentCancellation = false;
    public boolean isOrdershipmentCancellation() {
        return ordershipmentCancellation;
    }
    @Override
    public void shipmentState(Order order, String username, double price) {
        CustomerAccount account = null;
        account = account.getAccount(username);
        if(ordershipmentCancellation) {
            account.setBalance(account.getBalance() + shipmentVal);
        }
    }

    @Override
    public boolean setshipmentState(boolean ordershipmentCancellation) {
        this.ordershipmentCancellation=ordershipmentCancellation;
        return ordershipmentCancellation;
    }
}
