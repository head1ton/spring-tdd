package ai.springtest.order;

import static ai.springtest.order.OrderSteps.상품주문요청_생성;
import static org.assertj.core.api.Assertions.assertThat;

import ai.springtest.ApiTest;
import ai.springtest.product.ProductSteps;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;


public class OrderApiTest extends ApiTest {

    @Test
    @DisplayName("상품주문")
    public void 상품주문() {

        ProductSteps.상품등록요청(ProductSteps.상품등록요청_생성());
        final var request = 상품주문요청_생성();

        final var response = OrderSteps.상품주문요청(request);

        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
    }

}
