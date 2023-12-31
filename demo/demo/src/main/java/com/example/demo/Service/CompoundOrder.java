package com.example.demo.Service;

import ch.qos.logback.core.joran.sanity.Pair;
import com.example.demo.Common;
import com.example.demo.Model.CustomerAccount;
import com.example.demo.Model.Order;
import com.example.demo.Model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CompoundOrder extends Order {
    private List<Order> orders = new ArrayList<>();
    private OrderList orderList = OrderList.getInstant();
    @Override
    public List<Product> SelectProductsByNames(String usernames,List<String> productNames){
        try {
            setUsername(usernames);
            CustomerAccount account = new CustomerAccount();
            account = account.getAccount(usernames);
            List<Product> selectedProducts = new ArrayList<>();
            for (String name : productNames) {
                for (Product product : Common.products.values()) {
                        if (product.getName().equalsIgnoreCase(name)) {
                            selectedProducts.add(product);
                            Price = Price + product.getPrice();
                            break;
                        }
                    }
            }
            products = selectedProducts;
            Order order= this;
            orderList.addOrder(account,order);
            orders.add(order);
            return selectedProducts;
        }catch (Exception e){
            System.out.println("Exception in selectProduct as "+e.getMessage());
        }
        return null;
    }

    public void removeOrder(Order order){
        orders.remove(order);
    }
    public void addChild(Order order){
        orders.add(order);
    }
    public List<Order> GetChild(){
        return orders;
    }
}
