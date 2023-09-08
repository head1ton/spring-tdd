package ai.springtest.product;

import ai.springtest.product.enums.DiscountPolicy;
import org.springframework.util.Assert;

record GetProductResponse(Long id, String name, int price,
                          DiscountPolicy discountPolicy) {

    private GetProductResponse {
        Assert.notNull(id, "상품 ID는 필수입니다.");
        Assert.hasText(name, "상품명은 필수입니다.");
        Assert.notNull(discountPolicy, "할인 정책은 필수입니다.");
        // 가격은 할인 받으면 0원 일수도 있으니 체크를 빼고
    }
}
