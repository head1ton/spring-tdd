package ai.springtest.order.service;

import ai.springtest.order.domain.Order;
import ai.springtest.product.domain.Product;

public interface OrderPort {

    Product getProductById(final Long productId);

    void save(final Order order);
}
