package com.example.demo.Service;

import com.example.demo.Model.CustomerAccount;
import com.example.demo.Model.Notification;
import com.example.demo.Model.Order;

import java.util.List;
import java.util.Map;

public class OrderPlacementNotification extends Notification {
    public Map<CustomerAccount, List<Order>> orders = OrderList.getOrders();
    public void setOrders() {
        for (List<Order> orderList : orders.values()) {
            for (Order order : orderList) {
                if (!order.getOrderState()) {
                    orderList.remove(order);
                }
            }
        }
    }
    @Override
    public void send() {
        StringBuilder notification = new StringBuilder();
        for (Map.Entry<CustomerAccount, List<Order>> entry : orders.entrySet()){
            CustomerAccount customerAccount = entry.getKey();
            List<Order> customerOrders = entry.getValue();
            notification.append("Dear ").append(customerAccount.getUserName()).append(", your booking of the ");
            for (Order order : customerOrders){
                notification.append(order.getProducts());
            }
            notification.append("Thanks for using our store :)\n\n");
            NotificationQueue.enqueueNotification(notification.toString());
        }
    }
}
