package com.example.solid.ocp.notification;

//OpenClosedPrinciple:: Class should be open for extension and closed for modification

// Example-1
class BadNotificationService{
    public void send(String medium){
        if(medium.equalsIgnoreCase("sms")){
            //send sms notification..
        }
        if(medium.equalsIgnoreCase("email")){
            //send email notification..
        }
        //If we need push notification, we need to modify this class, by adding one more if condition.
        // this violates the OpenClosed Principle
    }
}
//Solution : create interface NotificationService with sendNotification() method ,
// then Subsequent classes will implement this interface to provide notification provider specific implementation

interface NotificationService{
    public void sendNotification(String medium);
}

class SMSNotification implements NotificationService{
    @Override
    public void sendNotification(String sms) {
        System.out.println("sending SMS notification ...");
    }
}

class EmailNotification implements NotificationService{

    @Override
    public void sendNotification(String email) {
        System.out.println("sending email notification ...");
    }
}

class PushNotification implements NotificationService{

    @Override
    public void sendNotification(String push) {
        System.out.println("send Push Notification ..");
    }
}
public class OpenClosedPrincipleExample1 {
    public static void main(String[] args) {
        NotificationService smsNotificationService= new SMSNotification();
        smsNotificationService.sendNotification("SMS");

        NotificationService emailNotification= new EmailNotification();
        emailNotification.sendNotification("EMAIL");

        NotificationService pushNotification= new PushNotification();
        pushNotification.sendNotification("PUSH");
    }
}
