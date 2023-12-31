package com.example.demo.Service;

import com.example.demo.Common;
import com.example.demo.Model.CustomerAccount;
import com.example.demo.Model.Order;
import com.example.demo.Model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SimpleOrder extends Order {
    private OrderList orderList = null;

    public SimpleOrder(){
        orderList = OrderList.getInstant();
    }

    @Override
    public List<Product> SelectProductsByNames(String username,List<String> productNames) {
        try {
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
            setUsername(username);
            CustomerAccount account = new CustomerAccount();
            account = account.getAccount(username);
            orderList.addOrder(account,this);
            Orderstate.OrderStatePlacement(username,getOrderNumber());
        }catch (Exception e){
            System.out.println("Exception in selectProduct as "+e.getMessage());
        }
        return null;
    }
}