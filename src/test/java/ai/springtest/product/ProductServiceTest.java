package ai.springtest.product;

import ai.springtest.product.dto.AddProductRequest;
import ai.springtest.product.enums.DiscountPolicy;
import ai.springtest.product.respository.ProductRepository;
import ai.springtest.product.service.ProductAdapter;
import ai.springtest.product.service.ProductPort;
import ai.springtest.product.service.ProductService;
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

    private static AddProductRequest 상품등록요청_생성() {
        String name = "상품명";
        int price = 1000;
        final AddProductRequest request = new AddProductRequest(name, price, DiscountPolicy.NONE);
        return request;
    }

    @Test
    @DisplayName("상품등록")
    public void 상품등록() {
        final AddProductRequest request = 상품등록요청_생성();

        productService.addProduct(request);
    }

}
