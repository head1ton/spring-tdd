package ai.springtest.product;

import static org.assertj.core.api.Assertions.assertThat;

import ai.springtest.ApiTest;
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

}
