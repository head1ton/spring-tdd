package ai.springtest.product;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ProductServiceTest {


    @Test
    @DisplayName("상품조회")
    public void 상품조회() {
        // 등록

        // 조회

        // 검증
        final GetProductResponse response = productService.getProduct(productId);
        assertThat(response).isNotNull();
    }
}
