package ai.springtest.product;

import ai.springtest.product.dto.AddProductRequest;
import ai.springtest.product.enums.DiscountPolicy;
import ai.springtest.product.service.ProductService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductServiceTest {

    @Autowired
    private ProductService productService;

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
