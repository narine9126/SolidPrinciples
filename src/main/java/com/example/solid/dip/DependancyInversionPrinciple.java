package com.example.solid.dip;

// Dependency Inversion Principle : High level modules should not depend on Low Level Module, both should depend on Abstraction.
interface PaymentGateway {
    void processPayment();
}

class PayPalPayment implements PaymentGateway { //PhonePePayment,GooglePayPayment etc
    @Override
    public void processPayment() {
        System.out.println("processing PayPal payment...");
    }
}

class CredPayment implements PaymentGateway{

    @Override
    public void processPayment() {
        System.out.println("processing Cred Payment...");
    }
}

class PaymentProcessor {
    // Here PaymentProcessor depends(HAS-A relationship) on PayPalPayment,CredPayment concrete implementation instead of abstraction.
    // PayPalPayment payPalPayment= new PayPalPayment();
    // CredPayment credPayment= new CredPayment();

    // To overcome this tight coupling, we can depend on interfaces or Abstract classes(Abstraction)
    private PaymentGateway paymentGateway;

    public PaymentProcessor(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public void processPayment() {
        paymentGateway.processPayment();
    }
}
/**
 * High-level module should not depend on low-level module, instead both should depend on abstraction.
 * i.e: Abstraction should not depend on details(Implementation), instead implementation should depend on Abstraction
 */

public class DependancyInversionPrinciple {
    public static void main(String[] args) {
        PaymentGateway payPalPayment= new PayPalPayment();
        PaymentGateway credPayment= new CredPayment();

        PaymentProcessor paymentProcessor= new PaymentProcessor(payPalPayment);
        paymentProcessor.processPayment();

        PaymentProcessor paymentProcessor1= new PaymentProcessor(credPayment);
        paymentProcessor1.processPayment();

    }
}
/**
 * In this example, PaymentProcessor depends on the PaymentGateway interface
 * instead of a specific payment gateway implementation like PayPalPayment or CredPayment.
 * This allows you to easily switch between different payment gateways by providing
 * a different implementation of the PaymentGateway interface.
 */
