package com.example.demo.Service;
import com.example.demo.Model.Notification;
import org.springframework.stereotype.Service;

@Service
public class SystemStatistics {
    Notification notification;
    public void mostSentTemplate(){
        try {
            int maxtemp= notification.maxtemp();
            if(notification.maxtemp()!=-1){
                System.out.println("The most sent notification template is ");
                if(maxtemp==0){
                System.out.println("Dear {x} , your booking of item {y} is confirmed. thanks for using our store :)");

                }else if(maxtemp==1){
                    System.out.println("Dear {x} , your shipment of item {y} is confirmed. thanks for using our store :)");

                }else if(maxtemp==2){
                    System.out.println("Dear {x} , your cancellation of item {y} is confirmed. thanks for using our store :)");

                }else if(maxtemp==3){
                    System.out.println("Dear {x} , your cancellation of the shipment of item {y} is confirmed. thanks for using our store :)");

            }}else {
                System.out.println("No existing notification yet");}
        }catch (Exception e){
            System.out.println("Exception in mostnotified as "+ e.getMessage());
        }
    }


}
