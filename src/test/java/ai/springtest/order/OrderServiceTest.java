package ai.springtest.order;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    @Test
    @DisplayName("상품주문")
    public void 상품주문() {
        orderService.createOrder(request);
    }
}
