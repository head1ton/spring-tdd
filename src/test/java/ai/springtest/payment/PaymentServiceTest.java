package ai.springtest.payment;

import ai.springtest.payment.controller.PaymentService;
import ai.springtest.payment.dto.PaymentRequest;
import ai.springtest.payment.repository.PaymentRepository;
import ai.springtest.payment.service.ConsolePaymentGateway;
import ai.springtest.payment.service.PaymentAdapter;
import ai.springtest.payment.service.PaymentGateway;
import ai.springtest.payment.service.PaymentPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PaymentServiceTest {

    private PaymentService paymentService;
    private PaymentPort paymentPort;
    private PaymentGateway paymentGateway;
    private PaymentRepository paymentRepository;

    @BeforeEach
    void setUp() {
        paymentGateway = new ConsolePaymentGateway();
        paymentRepository = new PaymentRepository();
        paymentPort = new PaymentAdapter(paymentGateway, paymentRepository);
        paymentService = new PaymentService(paymentPort);
    }

    private static PaymentRequest 주문결제요청_생성() {
        final Long orderId = 1L;
        final String cardNumber = "1234-1234-1234-1234";
        return new PaymentRequest(orderId, cardNumber);
    }

    @Test
    @DisplayName("상품주문")
    public void 상품주문() {

        final PaymentRequest request = 주문결제요청_생성();
        paymentService.payment(request);
    }

}
