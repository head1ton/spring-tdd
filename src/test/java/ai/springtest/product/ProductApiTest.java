package ai.springtest.product;

import static org.assertj.core.api.Assertions.assertThat;

import ai.springtest.ApiTest;
import ai.springtest.product.dto.AddProductRequest;
import ai.springtest.product.enums.DiscountPolicy;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;


public class ProductApiTest extends ApiTest {

    private static AddProductRequest 상품등록요청_생성() {
        String name = "상품명";
        int price = 1000;
        final AddProductRequest request = new AddProductRequest(name, price, DiscountPolicy.NONE);
        return request;
    }

    private static ExtractableResponse<Response> 상품등록요청(
        final AddProductRequest request) {
        return RestAssured.given().log().all()
                          .contentType(MediaType.APPLICATION_JSON_VALUE)
                          .body(request)
                          .when()
                          .post("/products")
                          .then()
                          .log().all().extract();
    }

    @Test
    @DisplayName("상품등록")
    public void 상품등록() {
        final var request = 상품등록요청_생성();

        final var response = 상품등록요청(request);

        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
    }

}
