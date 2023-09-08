package ai.springtest.order.controller;

import ai.springtest.order.dto.CreateOrderRequest;
import ai.springtest.order.service.OrderPort;
import ai.springtest.order.domain.Order;
import ai.springtest.product.domain.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderService {

    private final OrderPort orderPort;

    public OrderService(final OrderPort orderPort) {
        this.orderPort = orderPort;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Void> createOrder(@RequestBody final CreateOrderRequest request) {
        Product product = orderPort.getProductById(request.productId());
        Order order = new Order(product, request.quantity());

        orderPort.save(order);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
