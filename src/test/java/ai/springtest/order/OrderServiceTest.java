package ai.springtest.order;

import static ai.springtest.order.OrderSteps.상품주문요청_생성;
import static org.assertj.core.api.Assertions.assertThat;

import ai.springtest.ApiTest;
import ai.springtest.order.dto.CreateOrderRequest;
import ai.springtest.product.ProductSteps;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;


class OrderApiTest extends ApiTest {

    @Test
    @DisplayName("상품주문")
    public void 상품주문() {

        ProductSteps.상품등록요청(ProductSteps.상품등록요청_생성());
        final CreateOrderRequest request = 상품주문요청_생성();

        final ExtractableResponse<Response> response = RestAssured.given().log().all()
                                                                  .contentType(
                                                                      MediaType.APPLICATION_JSON_VALUE)
                                                                  .body(request)
                                                                  .when()
                                                                  .post("/orders")
                                                                  .then().log().all()
                                                                  .extract();

        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
    }

}
