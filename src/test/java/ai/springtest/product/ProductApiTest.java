package ai.springtest.product;

import static org.assertj.core.api.Assertions.assertThat;

import ai.springtest.ApiTest;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;


public class ProductApiTest extends ApiTest {

    @Test
    @DisplayName("상품등록")
    public void 상품등록() {
        final var request = ProductSteps.상품등록요청_생성();

        final var response = ProductSteps.상품등록요청(request);

        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
    }

    @Test
    @DisplayName("상품조회")
    public void 상품조회() {
        ProductSteps.상품등록요청(ProductSteps.상품등록요청_생성());
        Long productId = 1L;

        ExtractableResponse<Response> response = RestAssured.given().log().all()
                                                            .when()
                                                            .get("/products/{productId}")
                                                            .then().log().all()
                                                            .extract();

        assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
    }

}
