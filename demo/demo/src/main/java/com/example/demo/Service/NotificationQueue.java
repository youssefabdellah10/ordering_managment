package com.example.demo.Service;
import com.example.demo.Model.Notification;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.LinkedList;
public class NotificationQueue {
    private static Queue<String> queue = new LinkedList<>();
    public static void enqueueNotification(String notification){
        queue.add(notification);
    }
    public String dequeueNotification(){
        return queue.remove();
    }
}
