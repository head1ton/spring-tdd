package ai.springtest.order.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import ai.springtest.product.domain.Product;
import ai.springtest.product.enums.DiscountPolicy;
import org.junit.jupiter.api.Test;

class OrderTest {

    @Test
    void getTotalPrice() {
        Order order = new Order(new Product("상품명", 1000, DiscountPolicy.NONE), 2);
        int totalPrice = order.getTotalPrice();
        assertThat(totalPrice).isEqualTo(2000);
    }

    @Test
    void fix_getTotalPrice() {
        Order order = new Order(new Product("상품명", 2000, DiscountPolicy.FIX_1000_AMOUNT), 2);
        int totalPrice = order.getTotalPrice();
        assertThat(totalPrice).isEqualTo(2000);
    }
}