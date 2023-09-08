package ai.springtest.product;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import ai.springtest.product.domain.Product;
import ai.springtest.product.enums.DiscountPolicy;
import ai.springtest.product.service.ProductPort;
import ai.springtest.product.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
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
        final UpdateProductRequest request = new UpdateProductRequest("상품 수정", 2000,
            DiscountPolicy.NONE);
        Product product = new Product("상품명", 1000, DiscountPolicy.NONE);

        productService.updateProduct(productId, request);

        // 조회
        GetProductResponse response = productService.getProduct(productId);

        assertThat(response.name()).isEqualTo("상품 수정");
        assertThat(response.price()).isEqualTo(2000);
    }
}
