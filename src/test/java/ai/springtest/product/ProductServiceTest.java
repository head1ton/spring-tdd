package ai.springtest.product;

import ai.springtest.product.enums.DiscountPolicy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

public class ProductServiceTest {

    @Test
    @DisplayName("상품수정")
    public void 상품수정() {
        final Long productId = 1L;
        final UpdateProductRequest request = new UpdateProductRequest("상품 수정", 2000,
            DiscountPolicy.NONE);
        productService.updateProduct(productId, request);
    }

    private record UpdateProductRequest(String name, int price, DiscountPolicy discountPolicy) {

        private UpdateProductRequest {
            Assert.hasText(name, "상품명은 필수입니다.");
            Assert.isTrue(price > 0, "상품 가격은 0보다 커야 합니다.");
            Assert.notNull(discountPolicy, "할인 정책은 필수입니다.");
        }
    }
}
