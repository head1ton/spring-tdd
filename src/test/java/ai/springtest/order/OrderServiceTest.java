package ai.springtest.order;

import ai.springtest.order.controller.OrderService;
import ai.springtest.order.domain.Order;
import ai.springtest.order.dto.CreateOrderRequest;
import ai.springtest.order.respository.OrderRepository;
import ai.springtest.order.service.OrderPort;
import ai.springtest.product.domain.Product;
import ai.springtest.product.enums.DiscountPolicy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    private OrderService orderService;
    private OrderPort orderPort;
    private OrderRepository orderRepository;

    @BeforeEach
    void setUp() {
        orderRepository = new OrderRepository();
        orderPort = new OrderPort() {
            @Override
            public Product getProductById(final Long productId) {
                return new Product("상품명", 1000, DiscountPolicy.NONE);
            }

            @Override
            public void save(final Order order) {
                orderRepository.save(order);
            }
        };
        orderService = new OrderService(orderPort);
    }

    private static CreateOrderRequest 상품주문요청_생성() {
        final Long productId = 1L;
        final int quantity = 2;
        final CreateOrderRequest request = new CreateOrderRequest(productId, quantity);
        return request;
    }

    @Test
    @DisplayName("상품주문")
    public void 상품주문() {
        final CreateOrderRequest request = 상품주문요청_생성();

        orderService.createOrder(request);
    }

}
