package ai.springtest.order.controller;

import ai.springtest.order.dto.CreateOrderRequest;
import ai.springtest.order.service.OrderPort;
import ai.springtest.order.domain.Order;
import ai.springtest.product.domain.Product;
import org.springframework.stereotype.Component;

@Component
public class OrderService {

    private final OrderPort orderPort;

    public OrderService(final OrderPort orderPort) {
        this.orderPort = orderPort;
    }

    public void createOrder(final CreateOrderRequest request) {
        Product product = orderPort.getProductById(request.productId());
        Order order = new Order(product, request.quantity());

        orderPort.save(order);
    }
}
