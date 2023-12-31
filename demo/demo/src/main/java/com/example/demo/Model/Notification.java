package com.example.demo.Model;
import java.util.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public abstract class Notification {
    private static int[] tempNum = new int[4];  //the placement temp is in index 0, shipment 1, order cancellation 2 and shipment cancellation 3
    public void setTempNum(int index){
        tempNum[index]++;
    }
    public static int maxtemp(){
        int max=0;
        int index=-1;
        for(int i=0;i<4;i++){
            if(tempNum[i]>max){
                max=tempNum[i];
                index=i;
            }
        }
        return index;
    }
    public abstract void send(CustomerAccount customerAccount, List<Product> selectedProducts);


}
