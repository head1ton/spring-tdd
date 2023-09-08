package ai.springtest.order;

import ai.springtest.order.dto.CreateOrderRequest;

public class OrderSteps {

    static CreateOrderRequest 상품주문요청_생성() {
        final Long productId = 1L;
        final int quantity = 2;
        return new CreateOrderRequest(productId, quantity);
    }
}