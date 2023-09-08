package ai.springtest.payment.controller;

import ai.springtest.order.domain.Order;
import ai.springtest.payment.domain.Payment;
import ai.springtest.payment.dto.PaymentRequest;
import ai.springtest.payment.service.PaymentPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentService {

    private final PaymentPort paymentPort;

    public PaymentService(final PaymentPort paymentPort) {
        this.paymentPort = paymentPort;
    }

    @PostMapping("")
    @Transactional
    public ResponseEntity<Void> payment(@RequestBody final PaymentRequest request) {
        // payment 정보 가져와서 먼저 확인
        final Order order = paymentPort.getOrder(request.orderId());

        // 지불정보
        final Payment payment = new Payment(order, request.cardNumber());

        paymentPort.pay(payment.getPrice(), payment.getCardNumber());
        paymentPort.save(payment);

        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
