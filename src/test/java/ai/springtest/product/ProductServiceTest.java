package ai.springtest.product;

import static org.assertj.core.api.Assertions.assertThat;

import ai.springtest.product.service.ProductPort;
import ai.springtest.product.service.ProductService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductServiceTest {

    @Autowired
    private ProductService productService;
    @Autowired
    private ProductPort productPort;

    @Test
    @DisplayName("상품수정")
    public void 상품수정() {
        // 상품 등록
        productService.addProduct(ProductSteps.상품등록요청_생성());

        final Long productId = 1L;
        final var request = ProductSteps.상품수정요청();

        productService.updateProduct(productId, request);

        // 조회
        GetProductResponse response = productService.getProduct(productId);

        assertThat(response.name()).isEqualTo("상품 수정");
        assertThat(response.price()).isEqualTo(2000);
    }

}
