package ai.springtest.payment.service;


import ai.springtest.payment.domain.Payment;

public class ConsolePaymentGateway implements PaymentGateway {

    @Override
    public void execute(final int price, final String cardNumber) {
        System.out.println("결제 완료");
    }
}
