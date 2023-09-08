package ai.springtest.payment.service;


import ai.springtest.payment.domain.Payment;

public interface PaymentGateway {

    void execute(int price, String cardNumber);
}
