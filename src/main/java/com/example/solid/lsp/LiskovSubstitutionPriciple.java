package com.example.solid.lsp;

import java.util.List;

/**
 * Liskov Substitution Principle(LSP)
 * If Child class extends Parent class, then we should be able to replace Parent class Object with Child Class Object
 * Without breaking the application behaviour/functionality.
 * This is already available through Inheritance.
 *
 * Question: Then why we need separate Liskov Substitution Principle?
 * Answer: Even though inheritance allows substitution, there are certain scenarios where substituting Child Object actually
 * breaks the expected behaviour of the application.
 */
//Example::
interface NonRefundablePayments{
    void processPayment();
}
interface Payment extends NonRefundablePayments{
    void refund();
}
class WirePayment implements Payment{

    @Override
    public void processPayment() {
        System.out.println("Credit card payment done ...");
    }

    @Override
    public void refund() {
        System.out.println("Credit Card refund done ...");
    }
}

class ACHPayment implements Payment{

    @Override
    public void processPayment() {
        System.out.println("UPI payment done ...");
    }

    @Override
    public void refund() {
        System.out.println("UPI refund done ...");
    }

    public void checkBalance(){
        System.out.println("check balance using UPI..");
    }
}
class CHECKPayment implements Payment{

    @Override
    public void processPayment() {
        System.out.println("UPI payment done ...");
    }

    @Override
    public void refund() {
        System.out.println("UPI refund done ...");
    }

    public void checkBalance(){
        System.out.println("check balance using UPI..");
    }
}
class RTPPayment implements Payment{

    @Override
    public void processPayment() {
        System.out.println("UPI payment done ...");
    }

    @Override
    public void refund() {
        System.out.println("UPI refund done ...");
    }

    public void checkBalance(){
        System.out.println("check balance using UPI..");
    }
}

class Crypto implements NonRefundablePayments{

    @Override
    public void processPayment() {
        System.out.println("Crypto payment done ..");
    }

   /* @Override
    public void refund() {
        throw new UnsupportedOperationException("Refund not supported ...");
    }*/
}

class PaymentClient{
    public void processTransaction(Payment payment){
        payment.processPayment();
        payment.refund(); // throws UnsupportedOperationException() for Crypto exception
    }

    // have another overloaded processTransaction() method
    public void processTransaction(NonRefundablePayments nonRefundablePayment){
        nonRefundablePayment.processPayment();
    }
}
public class LiskovSubstitutionPriciple {
    public static void main(String[] args) {
        PaymentClient paymentClient= new PaymentClient();

        // Here we are passing child class objects in place of Parent class(Payment) in processTransaction() method,
        // This perfectly works due to Inheritance
        List<Payment> payments = List.of(new WirePayment(),new ACHPayment());
        for(Payment payment:payments){
            paymentClient.processTransaction(payment);
        }

        // This breaks the LSP principle as crypto not supporting refund () method in Payment interface(Abstraction)
        /*List<Payment> paymentsList = List.of(new CreditCard(),new UPI(), new Crypto());
        for(Payment payment:payments){
            paymentClient.processTransaction(payment);
        }*/

        // To overcome this problem, we can create another interface called NonRefundablePayments with processTransaction() method.
        // and we can keep Payment interface with refund() method.
        // Now we can extend nonRefundablePayments interface, like Payment extends nonRefundablePayments
        //List<Payment> paymentsList = List.of(new CreditCard(),new UPI(), new Crypto());
        List<Payment> paymentsList = List.of(new WirePayment(),new CHECKPayment(),new ACHPayment(),new RTPPayment());
        for(Payment payment:payments){
            paymentClient.processTransaction(payment);
        }

        NonRefundablePayments nonRefundablePayment= new Crypto();
        paymentClient.processTransaction(nonRefundablePayment);
    }
}

