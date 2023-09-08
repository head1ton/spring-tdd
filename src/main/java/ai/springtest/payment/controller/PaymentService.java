package ai.springtest.payment.controller;

import ai.springtest.order.domain.Order;
import ai.springtest.payment.domain.Payment;
import ai.springtest.payment.dto.PaymentRequest;
import ai.springtest.payment.service.PaymentPort;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Component
public class PaymentService {

    private final PaymentPort paymentPort;

    public PaymentService(final PaymentPort paymentPort) {
        this.paymentPort = paymentPort;
    }

    public void payment(final PaymentRequest request) {
        // payment 정보 가져와서 먼저 확인
        final Order order = paymentPort.getOrder(request.orderId());

        // 지불정보
        final Payment payment = new Payment(order, request.cardNumber());

        paymentPort.pay(payment.getPrice(), payment.getCardNumber());
        paymentPort.save(payment);

    }
}
