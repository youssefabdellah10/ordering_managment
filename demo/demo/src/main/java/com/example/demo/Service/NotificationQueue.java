package com.example.demo.Service;
import com.example.demo.Model.Notification;
import java.util.Iterator;
import java.util.Collection;
import java.util.concurrent.TimeUnit;
import java.util.Queue;
import java.util.LinkedList;
public class NotificationQueue {
    private static final Queue<String> queue = new LinkedList<>();
    private static final long cleanup_interval = TimeUnit.MINUTES.toMinutes(5);
    public static void enqueueNotification(String notification){
        queue.add(notification);
    }
    public String dequeueNotification(){
        return queue.remove();
    }
}
