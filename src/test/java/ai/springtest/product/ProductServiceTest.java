package ai.springtest.product;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ProductServiceTest {

    private ProductService productService;
    private ProductPort productPort;
    private ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        productRepository = new ProductRepository();
        productPort = new ProductAdapter(productRepository);
        productService = new ProductService(productPort);
    }

    @Test
    @DisplayName("상품등록")
    public void 상품등록() {
        String name = "상품명";
        int price = 1000;
        final AddProductRequest request = new AddProductRequest(name, price, DiscountPolicy.NONE);
        productService.addProduct(request);
    }

}
