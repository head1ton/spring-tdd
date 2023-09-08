package ai.springtest.payment;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PaymentServiceTest {

    @Test
    @DisplayName("상품주문")
    public void 상품주문() {

        final Long orderId = 1L;
        final String cardNumber = "1234-1234-1234-1234";
        final PaymentRequest request = new PaymentRequest(orderId, cardNumber);
        paymentService.payment(request);
    }

    private class PaymentRequest {

        public PaymentRequest(final Long orderId, final String cardNumber) {

        }
    }
}
