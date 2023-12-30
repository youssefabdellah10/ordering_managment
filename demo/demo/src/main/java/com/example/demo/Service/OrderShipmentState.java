package com.example.demo.Service;
import com.example.demo.Model.CustomerAccount;
import org.springframework.stereotype.Service;
public class OrderShipmentState {
    private boolean orderShipmentState = false;
    private OrderList orderList = OrderList.getInstant();

    public boolean OrderShipmentState() {
        return orderShipmentState;
    }
    public void OrderShipmentStatePlacement(String username,int orderID){
        CustomerAccount account = new CustomerAccount();
        account = account.getAccount(username);
        if(orderList.ReturnOrder(username,orderID).getOrderShipmentState()){
            return;
        }else{
            orderList.ReturnOrder(username,orderID).setOrderShipmentState(true);
            orderShipmentState = true;
            account.setBalance(account.getBalance() - orderList.ReturnOrder(username,orderID).getShipping());
        }
    }
    public void OrderShipmentStateCancellation(String username, int orderID){
        CustomerAccount account = new CustomerAccount();
        account.getAccount(username);
        if(!orderList.ReturnOrder(username,orderID).getOrderShipmentState()){
            return;
        }else{
            orderList.ReturnOrder(username,orderID).setOrderShipmentState(false);
            orderShipmentState = false;
            account.setBalance(account.getBalance() - orderList.ReturnOrder(username,orderID).getShipping());
        }
    }
}
