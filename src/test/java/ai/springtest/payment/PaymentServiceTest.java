package ai.springtest.payment;

import ai.springtest.order.OrderSteps;
import ai.springtest.order.controller.OrderService;
import ai.springtest.payment.controller.PaymentService;
import ai.springtest.payment.dto.PaymentRequest;
import ai.springtest.payment.repository.PaymentRepository;
import ai.springtest.payment.service.ConsolePaymentGateway;
import ai.springtest.payment.service.PaymentAdapter;
import ai.springtest.payment.service.PaymentGateway;
import ai.springtest.payment.service.PaymentPort;
import ai.springtest.product.ProductSteps;
import ai.springtest.product.controller.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PaymentServiceTest {

    @Autowired
    private ProductService productService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private PaymentService paymentService;

    @Test
    @DisplayName("상품주문")
    public void 상품주문() {

        productService.addProduct(ProductSteps.상품등록요청_생성());
        orderService.createOrder(OrderSteps.상품주문요청_생성());
        final PaymentRequest request = PaymentSteps.주문결제요청_생성();

        paymentService.payment(request);
    }

}
