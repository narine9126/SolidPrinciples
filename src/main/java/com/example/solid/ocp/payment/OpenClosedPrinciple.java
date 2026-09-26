package com.example.solid.ocp.payment;

/**
 * OCP (OpenClosedPrinciple) :  Class should be open for extension and closed for modification
 * Example: PaymentSystem Service
 */
//---------------------- Example-2
//Bad design Example:
class PaymentSystem{
    public void processPayment(String paymentType){
        if("ApplePay".equalsIgnoreCase(paymentType)){
            System.out.println("processing ApplePay payment ...");
        }
        if("UPI".equalsIgnoreCase(paymentType)){
            System.out.println("processing UPI payment ...");
        }
        // If we want to pay through PayPal, Cred, Stripe, Paytm, AmazonPay etc payment Types , then we need to modify this class to accommodate those payment types.
        // This violates Open Closed Principle.
    }
}

// Solution::
interface PaymentService{
    void processPayment(double amount);
}

class UPIPayment implements PaymentService{

    @Override
    public void processPayment(double amount) {
        System.out.println("processing UPI payment  ...");
    }
}

class PayPalPayment implements PaymentService{

    @Override
    public void processPayment(double amount) {
        System.out.println("processing PayPal payment..");
    }
}

class CredPayment implements PaymentService{

    @Override
    public void processPayment(double amount) {
        System.out.println("processing payment via Cred ..");
    }
}


public class OpenClosedPrinciple{
    public static void main(String[] args) {
        // Payment Service
        PaymentService upiPaymentService= new UPIPayment();
        upiPaymentService.processPayment(585858L);

        PaymentService paypalPaymentService = new PayPalPayment();
        paypalPaymentService.processPayment(37373L);

        PaymentService credPaymentService = new CredPayment();
        credPaymentService.processPayment(22626L);
    }
}


