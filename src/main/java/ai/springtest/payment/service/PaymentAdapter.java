package ai.springtest.payment.service;

import ai.springtest.order.domain.Order;
import ai.springtest.order.respository.OrderRepository;
import ai.springtest.payment.domain.Payment;
import ai.springtest.payment.repository.PaymentRepository;
import ai.springtest.product.domain.Product;
import ai.springtest.product.enums.DiscountPolicy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class PaymentAdapter implements PaymentPort {

    private final PaymentGateway paymentGateway;
    private final PaymentRepository paymentRepository;
    private final OrderRepository orderRepository;

    public PaymentAdapter(final PaymentGateway paymentGateway,
        final PaymentRepository paymentRepository, final OrderRepository orderRepository) {
        this.paymentGateway = paymentGateway;
        this.paymentRepository = paymentRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public Order getOrder(final Long id) {
        return orderRepository.findById(id)
                              .orElseThrow(() -> new IllegalArgumentException("주문이 존재하지 않습니다."));
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
