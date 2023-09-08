package ai.springtest.payment;

import ai.springtest.order.domain.Order;
import ai.springtest.product.domain.Product;
import ai.springtest.product.enums.DiscountPolicy;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.HashMap;
import java.util.Map;
import lombok.Getter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

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

    @Test
    @DisplayName("상품주문")
    public void 상품주문() {

        final Long orderId = 1L;
        final String cardNumber = "1234-1234-1234-1234";
        final PaymentRequest request = new PaymentRequest(orderId, cardNumber);
        paymentService.payment(request);
    }

    private record PaymentRequest(Long orderId, String cardNumber) {

        private PaymentRequest {
            Assert.notNull(orderId, "주문 ID는 필수입니다.");
            Assert.hasText(cardNumber, "카드 정보는 필수입니다.");
        }
    }

    private interface PaymentPort {

        Order getOrder(Long id);

        void pay(Payment payment);

        void save(Payment payment);
    }

    private interface PaymentGateway {

        void execute(Payment payment);
    }

    private class PaymentService {

        private final PaymentPort paymentPort;

        private PaymentService(final PaymentPort paymentPort) {
            this.paymentPort = paymentPort;
        }

        public void payment(final PaymentRequest request) {
            // payment 정보 가져와서 먼저 확인
            Order order = paymentPort.getOrder(request.orderId());

            // 지불정보
            Payment payment = new Payment(order, request.cardNumber());

            paymentPort.pay(payment);
            paymentPort.save(payment);

        }
    }

    private class Payment {

        private final Order order;
        private final String cardNumber;
        @Getter
        private Long id;

        public Payment(final Order order, final String cardNumber) {
            Assert.notNull(order, "주문은 필수입니다.");
            Assert.hasText(cardNumber, "카드 번호는 필수입니다.");
            this.order = order;
            this.cardNumber = cardNumber;
        }

        public void assignId(final Long id) {
            this.id = id;
        }
    }

    private class PaymentAdapter implements PaymentPort {

        private final PaymentGateway paymentGateway;
        private final PaymentRepository paymentRepository;

        private PaymentAdapter(final PaymentGateway paymentGateway,
            final PaymentRepository paymentRepository) {
            this.paymentGateway = paymentGateway;
            this.paymentRepository = paymentRepository;
        }

        @Override
        public Order getOrder(final Long id) {
            return new Order(new Product("상품1", 1000, DiscountPolicy.NONE), 1);
        }

        @Override
        public void pay(final Payment payment) {
            paymentGateway.execute(payment);    // pg 사 결제 모듈 연동으로 가정
        }

        @Override
        public void save(final Payment payment) {
            paymentRepository.save(payment);
        }
    }

    public class ConsolePaymentGateway implements PaymentGateway {

        @Override
        public void execute(final Payment payment) {
            System.out.println("결제 완료");
        }
    }

    private class PaymentRepository {

        private Long sequence = 1L;
        private final Map<Long, Payment> persistence = new HashMap<>();

        public void save(final Payment payment) {
            payment.assignId(++sequence);
            persistence.put(payment.getId(), payment);
        }
    }
}
