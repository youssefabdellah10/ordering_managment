package com.example.demo.Service;


import com.example.demo.Model.CustomerAccount;
import org.springframework.stereotype.Service;

@Service
public class OrderState {
    private boolean orderState = false;
    private OrderList orderList = OrderList.getInstant();

    public boolean OrderState() {
        return orderState;
    }
    public void OrderStatePlacement(String username,int orderID){
        CustomerAccount account = new CustomerAccount();
        account = account.getAccount(username);
        if(orderList.ReturnOrder(username,orderID).getOrderState()){
            return;
        }else{
            orderList.ReturnOrder(username,orderID).setOrderState(true);
            orderState = true;
            account.setBalance(account.getBalance() - orderList.ReturnOrder(username,orderID).getOrderPrice());
        }
    }
    public void OrderStateCancellation(String username, int orderID){
        CustomerAccount account = new CustomerAccount();
        account.getAccount(username);
        if(!orderList.ReturnOrder(username,orderID).getOrderState()){
            return;
        }else{
            orderList.ReturnOrder(username,orderID).setOrderState(false);
            orderState = false;
            account.setBalance(account.getBalance() - orderList.ReturnOrder(username,orderID).getOrderPrice());
        }
    }
}
