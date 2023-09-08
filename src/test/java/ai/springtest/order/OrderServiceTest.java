package ai.springtest.order;

import ai.springtest.order.controller.OrderService;
import ai.springtest.order.dto.CreateOrderRequest;
import ai.springtest.product.ProductSteps;
import ai.springtest.product.controller.ProductService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OrderServiceTest {

    @Autowired
    private OrderService orderService;
    @Autowired
    private ProductService productService;

    @Test
    @DisplayName("상품주문")
    public void 상품주문() {
        // 상품 등록
        productService.addProduct(ProductSteps.상품등록요청_생성());

        final CreateOrderRequest request = OrderSteps.상품주문요청_생성();

        orderService.createOrder(request);
    }

}
