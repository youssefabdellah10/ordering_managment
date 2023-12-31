package com.example.demo.Service;


import com.example.demo.Common;
import com.example.demo.Model.CustomerAccount;
import com.example.demo.Model.Notification;
import com.example.demo.Model.Order;
import com.example.demo.Model.Product;
import org.springframework.stereotype.Service;


import java.util.Map;

@Service
public class OrderState {
    private boolean orderState = false;
    Notification notification;
    private OrderList orderList = OrderList.getInstant();

    public boolean OrderState() {
        return orderState;
    }
    public void OrderStatePlacement(String username,int orderID){
        CustomerAccount account = new CustomerAccount();
        Order order;
        account = account.getAccount(username);
        if(orderList.ReturnOrder(username,orderID).getOrderState()){
            return;
        }else{
            order =  orderList.ReturnOrder(username,orderID);
            order.setOrderState(true);
            for(Product product : order.getProducts()){
                for (Map.Entry<String, Product> entry : Common.products.entrySet()){
                    if(product == entry.getValue()){
                        entry.getValue().setQuantity(product.getQuantity()-1);
                    }
                }
            }
            orderState = true;
            account.setBalance(account.getBalance() - orderList.ReturnOrder(username,orderID).getOrderPrice());
        }
    }
    public void OrderStateCancellation(String username, int orderID){
        CustomerAccount account = new CustomerAccount();
        Order order;
        account.getAccount(username);
        if(!orderList.ReturnOrder(username,orderID).getOrderState()){
            return;
        }else{
            order =  orderList.ReturnOrder(username,orderID);
            order.setOrderState(false);
            for(Product product : order.getProducts()){
                for (Map.Entry<String, Product> entry : Common.products.entrySet()){
                    if(product == entry.getValue()){
                        entry.getValue().setQuantity(product.getQuantity()+1);
                    }
                }
            }
            orderState = false;
            account.setBalance(account.getBalance() - orderList.ReturnOrder(username,orderID).getOrderPrice());
        }
    }
}
