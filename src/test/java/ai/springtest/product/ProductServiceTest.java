package ai.springtest.product;

import static org.assertj.core.api.Assertions.assertThat;

import ai.springtest.product.service.ProductService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @Test
    @DisplayName("상품조회")
    public void 상품조회() {
        // 등록
        productService.addProduct(ProductSteps.상품등록요청_생성());
        final Long productId = 1L;

        // 조회
        final GetProductResponse response = productService.getProduct(productId);

        // 검증
        assertThat(response).isNotNull();
    }

}
