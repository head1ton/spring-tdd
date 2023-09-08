package ai.springtest.payment;

import static org.assertj.core.api.Assertions.assertThat;

import ai.springtest.ApiTest;
import ai.springtest.order.OrderSteps;
import ai.springtest.payment.dto.PaymentRequest;
import ai.springtest.product.ProductSteps;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

public class PaymentApiTest extends ApiTest {

    @Test
    @DisplayName("상품주문")
    public void 상품주문() {

        ProductSteps.상품등록요청(ProductSteps.상품등록요청_생성());
        OrderSteps.상품주문요청(OrderSteps.상품주문요청_생성());
        final var request = PaymentSteps.주문결제요청_생성();

        final var response = PaymentSteps.주문결제요청(request);

        assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
    }

}
