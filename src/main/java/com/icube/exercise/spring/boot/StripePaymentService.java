package com.icube.exercise.spring.boot;

public class StripePaymentService {
    public void processPayment(double amount) {
        System.out.println("STRIPE");
        System.out.println("Amount: " + amount);
    }
}
