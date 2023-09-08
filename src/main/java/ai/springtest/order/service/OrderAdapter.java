package ai.springtest.order.service;

import ai.springtest.order.domain.Order;
import ai.springtest.order.respository.OrderRepository;
import ai.springtest.product.domain.Product;
import ai.springtest.product.respository.ProductRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class OrderAdapter implements OrderPort {

    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    private OrderAdapter(final ProductRepository productRepository,
        final OrderRepository orderRepository) {
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public Product getProductById(final Long productId) {
        return productRepository.findById(productId)
                                .orElseThrow(
                                    () -> new IllegalArgumentException("상품이 존재하지 않습니다."));
    }

    @Override
    public void save(final Order order) {
        orderRepository.save(order);
    }
}
