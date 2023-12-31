package com.example.demo.Service;
import com.example.demo.Common;
import com.example.demo.Model.Notification;
import com.example.demo.Model.Product;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.TimeUnit;
@Service

public class NotificationQueue {
    private static final Queue<String> queue = new LinkedList<>();
    private static final long cleanup_interval = TimeUnit.MINUTES.toMinutes(5);
    public static void enqueueNotification(String notification){

        queue.add(notification);
    }
    public String dequeueNotification(){
        return queue.remove();
    }
    public String[] listQueue(){
        try{
            String [] q = new String[queue.size()];
            int i=0;
            for(String template : queue){
                q[i] = template;
                i++;
            }
            return q;
        }catch (Exception e){
            System.out.println("Exception in listQueue as "+ e.getMessage());
        }
        return null;
    }
}
