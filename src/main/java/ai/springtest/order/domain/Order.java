package ai.springtest.order.domain;

import ai.springtest.product.domain.Product;
import lombok.Getter;
import org.springframework.util.Assert;

public class Order {

    private final Product product;
    private final int quantity;
    @Getter
    private Long id;

    public Order(final Product product, final int quantity) {
        Assert.notNull(product, "상품은 필수입니다.");
        Assert.isTrue(quantity > 0, "수량은 0보다 커야 합니다.");
        this.product = product;
        this.quantity = quantity;
    }

    public void assignId(final Long id) {
        this.id = id;
    }
}
