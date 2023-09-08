package ai.springtest.payment.domain;

import ai.springtest.order.domain.Order;
import lombok.Getter;
import org.springframework.util.Assert;

@Getter
public class Payment {

    private final Order order;
    private final String cardNumber;
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

    public int getPrice() {
        return order.getTotalPrice();
    }

}