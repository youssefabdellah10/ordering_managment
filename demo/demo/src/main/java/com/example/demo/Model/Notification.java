package com.example.demo.Model;
import com.example.demo.Common;
import com.example.demo.Service.OrderList;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public interface Notification {

    public void send(CustomerAccount customerAccount, List<Product> selectedProducts);

}
