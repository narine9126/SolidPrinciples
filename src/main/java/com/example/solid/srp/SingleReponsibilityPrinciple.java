package com.example.solid.srp;

/**
 * SOLID:
 * 1) Single Responsibility Principle.
 * 2) Open/closed Principle.
 * 3) Liskov substitution Principle.
 * 4) Interface Segregation Principle.
 * 5) Dependency Inversion Principle.
 */

/**
 * Single Responsibility Principle (SRP):
 * A class should have only one reason to change, meaning it should have only one responsibility or job.
 * This principle helps to keep classes focused and maintainable, making it easier to understand and modify.
 * Here is an example of a class that violates the Single Responsibility Principle:
 * This class BadOrderService has multiple responsibilities: placing an order, generating an invoice, and sending a notification.
 * If any of these responsibilities change, the class will need to be modified, which can lead to unintended side effects.
 */

//Bad Design Example:
class BadOrderService{
    public void placeOrder(){
        System.out.println("Placing order ...");
    }
    public void generateInvoice(){
        System.out.println("Generating invoice ...");
    }
    public void sendNotification() {
        System.out.println("Sending notification ...");
    }
}

//Solution: We can refactor the above class into three separate classes, each with a single responsibility:
class OrderService{
    public void placeOrder(){
        System.out.println("Placing order ...");
    }
}
class InvoiceService{
    public void generateInvoice(){
        System.out.println("Generating invoice ...");
    }
}
class NotificationService{
    public void sendNotification() {
        System.out.println("Sending notification ...");
    }
}

public class SingleReponsibilityPrinciple {
    public static void main(String[] args) {
        OrderService orderService= new OrderService();
        orderService.placeOrder();

        InvoiceService invoiceService= new InvoiceService();
        invoiceService.generateInvoice();

        NotificationService notificationService= new NotificationService();
        notificationService.sendNotification();
    }
}



//KAFKA:: https://www.youtube.com/watch?v=yW6JYi88OMU&list=PLmNHrXceNeQ1Kyg5cxmshCkQy_T-BeoNT
// Springboot : transaction retry mechanism in springboot
// valid paranthesis : ({[]}) -valid, ({[}]) - invalid
// Kth element in the list.
// DB sharding

//https://www.youtube.com/watch?v=TzdTRNPlJts --- kafka installation on windows
