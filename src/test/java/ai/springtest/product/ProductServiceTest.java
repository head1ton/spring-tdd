package ai.springtest.product;

import ai.springtest.product.domain.Product;
import ai.springtest.product.enums.DiscountPolicy;
import ai.springtest.product.service.ProductPort;
import ai.springtest.product.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ProductServiceTest {

    private ProductService productService;

    @BeforeEach
    void setUp() {
        final ProductPort productPort = new ProductPort() {
            @Override
            public void save(final Product product) {

            }

            @Override
            public Product getProduct(final Long productId) {
                return null;
            }
        };
        productService = new ProductService(productPort);
    }

    @Test
    @DisplayName("상품수정")
    public void 상품수정() {
        final Long productId = 1L;
        final UpdateProductRequest request = new UpdateProductRequest("상품 수정", 2000,
            DiscountPolicy.NONE);
        productService.updateProduct(productId, request);
    }

}
