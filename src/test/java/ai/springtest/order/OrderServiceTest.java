package ai.springtest.order;

import ai.springtest.order.controller.OrderService;
import ai.springtest.order.dto.CreateOrderRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OrderServiceTest {

    @Autowired
    private OrderService orderService;

    @Test
    @DisplayName("상품주문")
    public void 상품주문() {
        final CreateOrderRequest request = OrderSteps.상품주문요청_생성();

        orderService.createOrder(request);
    }

}
