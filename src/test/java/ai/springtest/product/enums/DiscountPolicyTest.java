package ai.springtest.product.enums;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DiscountPolicyTest {

    @Test
    void noneDiscountPolicy() {
        int price = 1000;
        int discountedPrice = DiscountPolicy.NONE.applyDiscount(price);
        assertThat(discountedPrice).isEqualTo(price);
    }

    @Test
    void fix_1000_DiscountPolicy() {
        int price = 2000;
        int discountedPrice = DiscountPolicy.FIX_1000_AMOUNT.applyDiscount(price);
        assertThat(discountedPrice).isEqualTo(1000);
    }

    @Test
    public void over_discounted_price() {
        final int price = 500;
        final int discountedPrice = DiscountPolicy.FIX_1000_AMOUNT.applyDiscount(price);

        assertThat(discountedPrice).isEqualTo(0);
    }
}