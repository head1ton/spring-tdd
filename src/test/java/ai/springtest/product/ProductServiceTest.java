package ai.springtest.product;

import static org.assertj.core.api.Assertions.assertThat;

import ai.springtest.product.enums.DiscountPolicy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

public class ProductServiceTest {


    @Test
    @DisplayName("상품조회")
    public void 상품조회() {
        // 등록
        final Long productId = 1L;

        // 조회

        // 검증
        final GetProductResponse response = productService.getProduct(productId);
        assertThat(response).isNotNull();
    }

    private class GetProductResponse {

        private final Long id;
        private final String name;
        private final int price;
        private final DiscountPolicy discountPolicy;

        public GetProductResponse(final Long id, final String name, final int price,
            final DiscountPolicy discountPolicy) {
            Assert.notNull(id, "상품 ID는 필수입니다.");
            Assert.hasText(name, "상품명은 필수입니다.");
            Assert.notNull(discountPolicy, "할인 정책은 필수입니다.");
            // 가격은 할인 받으면 0원 일수도 있으니 체크를 빼고
            this.id = id;
            this.name = name;
            this.price = price;
            this.discountPolicy = discountPolicy;
        }
    }
}
