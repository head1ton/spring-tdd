package ai.springtest.payment.dto;

import org.springframework.util.Assert;

public record PaymentRequest(Long orderId, String cardNumber) {

    public PaymentRequest {
        Assert.notNull(orderId, "주문 ID는 필수입니다.");
        Assert.hasText(cardNumber, "카드 정보는 필수입니다.");
    }
}
