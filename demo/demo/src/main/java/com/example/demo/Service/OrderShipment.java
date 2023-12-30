package com.example.demo.Service;
import com.example.demo.Common;
import com.example.demo.Model.CustomerAccount;
import com.example.demo.Model.Order;

public class OrderShipment implements OrderingShipmentState {
    int shipmentVal = 100;
    private boolean shipmentPlacement = false;
    public boolean isShipmentPlacement() {
        return shipmentPlacement;
    }

    @Override
    public void shipmentState(Order order, String username, double price) {
        CustomerAccount account = null;
        account = account.getAccount(username);
        if(shipmentPlacement){
            account.setBalance(account.getBalance() - shipmentVal);
        }
    }

    @Override
    public boolean setshipmentState(boolean shipmentPlacement) {
        this.shipmentPlacement = shipmentPlacement;
        return shipmentPlacement;
    }
}
