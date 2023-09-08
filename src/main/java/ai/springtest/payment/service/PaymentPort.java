package ai.springtest.payment.service;

import ai.springtest.order.domain.Order;
import ai.springtest.payment.domain.Payment;

public interface PaymentPort {

    Order getOrder(Long id);

    void pay(Payment payment);

    void save(Payment payment);
}
