package com.example.solid.isp;

/**
 * A Class that is not forced to implement a method that it is not wanted to/ not required.
 *
 */

interface NotificationService1{
    public void sendEmailNotification(String email);
    public void sendSMSNotification(String sms);
}
/**
 * here class EmailNotificationService forced to implement sendSMSNotification() method which is irrelevant for EmailNotificationService.
 * That is forced to provide implementation.
 * And class SmsNotificationService forced to implement sendEmailNotification() method which is irrelevant for SmsNotificationService.
 * That is forced to provide implementation.
 */
class EmailNotificationService implements NotificationService1{

    @Override
    public void sendEmailNotification(String email) {
        System.out.println("sending Email Notification ...");
    }
    @Override
    public void sendSMSNotification(String sms) {
        System.out.println("sending SMS Notification ..."); // this method forced to implement in  EmailNotificationService.
    }
}

class SmsNotificationService implements NotificationService1{

    @Override
    public void sendEmailNotification(String email) {
        System.out.println("sending Email Notification ...");// this method forced to implement in SmsNotificationService.
    }
    @Override
    public void sendSMSNotification(String sms) {
        System.out.println("sending SMS Notification ...");
    }
}

/**
 * solution: segregate the interface
 */

interface EmailNotification1{
    public void sendEmailNotification(String email);
}

interface SMSNotification1{
    public void sendSMSNotification(String sms);
}

class EmailService implements EmailNotification1{

    @Override
    public void sendEmailNotification(String email) {
        System.out.println("sending Email Notification ...");
    }
}

class SMSService implements SMSNotification1{

    @Override
    public void sendSMSNotification(String sms) {
        System.out.println("sending SMS Notification ...");
    }
}

/**
 * client should not force to implement interface which is irrelevant to them.
 */
public interface InterfaceSegregationPrinciple {
    public static void main(String[] args) {
        EmailNotification1 emailNotification= new EmailService();
        emailNotification.sendEmailNotification("Hello Buddy!");

        SMSNotification1 smsNotification= new SMSService();
        smsNotification.sendSMSNotification("Hello Friend!");
    }
}
