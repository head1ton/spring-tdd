package ai.springtest.payment.service;

import ai.springtest.order.domain.Order;
import ai.springtest.payment.domain.Payment;
import ai.springtest.payment.repository.PaymentRepository;
import ai.springtest.product.domain.Product;
import ai.springtest.product.enums.DiscountPolicy;
import org.springframework.stereotype.Component;

@Component
public class PaymentAdapter implements PaymentPort {

    private final PaymentGateway paymentGateway;
    private final PaymentRepository paymentRepository;

    public PaymentAdapter(final PaymentGateway paymentGateway,
        final PaymentRepository paymentRepository) {
        this.paymentGateway = paymentGateway;
        this.paymentRepository = paymentRepository;
    }

    @Override
    public Order getOrder(final Long id) {
        return new Order(new Product("상품1", 1000, DiscountPolicy.NONE), 1);
    }

    @Override
    public void save(final Payment payment) {
        paymentRepository.save(payment);
    }

    @Override
    public void pay(final int price, final String cardNumber) {
        paymentGateway.execute(price, cardNumber);      // pg 사 결제 모듈 연동으로 가정
    }
}
