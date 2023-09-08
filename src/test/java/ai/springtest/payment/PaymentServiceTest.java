package ai.springtest.payment;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

public class PaymentServiceTest {

    private PaymentService paymentService;

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

    private class PaymentService {

        public void payment(final PaymentRequest request) {
            throw new UnsupportedOperationException("Unsupported payment");
        }
    }
}
