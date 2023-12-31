package com.example.demo.Service;

import com.example.demo.Model.CustomerAccount;
import com.example.demo.Model.Notification;
import com.example.demo.Model.Order;
import com.example.demo.Model.Product;

import java.util.List;
public class OrderPlacementNotification implements Notification {
    @Override
    public void send(CustomerAccount customerAccount, List<Product> products) {
        StringBuilder notification = new StringBuilder();
        notification.append("Dear ").append(customerAccount.getUserName()).append(", your booking of the item ");
        for (Product product : products){
            notification.append(product.getName()).append(" ");
        }
        notification.append("is confirmed, Thanks for using our store :)");
        NotificationQueue.enqueueNotification(notification.toString());
    }
}
