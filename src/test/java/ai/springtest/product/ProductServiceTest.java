package ai.springtest.product;

import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

public class ProductServiceTest {

    @Test
    @DisplayName("상품등록")
    public void 상품등록() {
        String name = "상품명";
        int price = 1000;
        final AddProductRequest request = new AddProductRequest(name, price, DiscountPolicy.NONE);
        productService.addProduct(request);
    }

    private enum DiscountPolicy {
        NONE

    }

    private class AddProductRequest {

    }
}
