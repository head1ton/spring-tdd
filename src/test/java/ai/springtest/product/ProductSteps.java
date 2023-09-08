package ai.springtest.product;

import ai.springtest.product.dto.AddProductRequest;
import ai.springtest.product.enums.DiscountPolicy;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.springframework.http.MediaType;

public class ProductSteps {

    public static AddProductRequest 상품등록요청_생성() {
        String name = "상품명";
        int price = 1000;
        final AddProductRequest request = new AddProductRequest(name, price, DiscountPolicy.NONE);
        return request;
    }

    public static ExtractableResponse<Response> 상품등록요청(
        final AddProductRequest request) {
        return RestAssured.given().log().all()
                          .contentType(MediaType.APPLICATION_JSON_VALUE)
                          .body(request)
                          .when()
                          .post("/products")
                          .then()
                          .log().all().extract();
    }

    public static ExtractableResponse<Response> 상품조회요청(
        final Long productId) {
        return RestAssured.given().log().all()
                          .when()
                          .get("/products/{productId}", productId)
                          .then().log().all()
                          .extract();
    }

    public static UpdateProductRequest 상품수정요청() {
        return new UpdateProductRequest("상품 수정", 2000,
            DiscountPolicy.NONE);
    }
}