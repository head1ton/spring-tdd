package ai.springtest.product;

import java.util.HashMap;
import java.util.Map;
import lombok.Getter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

public class ProductServiceTest {

    private ProductService productService;
    private ProductPort productPort;
    private ProductRepository productRepository;

    @BeforeEach
    void setUp() {
        productRepository = new ProductRepository();
        productPort = new ProductAdapter(productRepository);
        productService = new ProductService(productPort);
    }

    @Test
    @DisplayName("상품등록")
    public void 상품등록() {
        String name = "상품명";
        int price = 1000;
        final AddProductRequest request = new AddProductRequest(name, price, DiscountPolicy.NONE);
        productService.addProduct(request);
    }

    public enum DiscountPolicy {
        NONE

    }

    public interface ProductPort {

        void save(final Product product);
    }

    public record AddProductRequest(String name, int price, DiscountPolicy discountPolicy) {

        public AddProductRequest {
            Assert.hasText(name, "상품명은 필수입니다.");
            Assert.isTrue(price > 0, "상품 가격은 0보다 커야 합니다.");
            Assert.notNull(discountPolicy, "할인 정책은 필수입니다.");
        }

    }

    public class ProductService {

        private final ProductPort productPort;

        private ProductService(final ProductPort productPort) {
            this.productPort = productPort;
        }

        public void addProduct(final AddProductRequest request) {
            Product product = new Product(request.name(), request.price(),
                request.discountPolicy());

            productPort.save(product);
        }
    }

    public class Product {

        @Getter
        private Long id;
        private final String name;
        private final int price;
        private final DiscountPolicy discountPolicy;

        public Product(final String name, final int price, final DiscountPolicy discountPolicy) {
            Assert.hasText(name, "상품명은 필수입니다.");
            Assert.isTrue(price > 0, "상품 가격은 0보다 커야 합니다.");
            Assert.notNull(discountPolicy, "할인 정책은 필수입니다.");
            this.name = name;
            this.price = price;
            this.discountPolicy = discountPolicy;
        }

        public void assignId(final Long id) {
            this.id = id;
        }
    }

    public class ProductAdapter implements ProductPort {

        private final ProductRepository productRepository;

        private ProductAdapter(final ProductRepository productRepository) {
            this.productRepository = productRepository;
        }

        @Override
        public void save(final Product product) {
            productRepository.save(product);
        }
    }

    public class ProductRepository {

        private Long sequence = 0L;
        private final Map<Long, Product> persistence = new HashMap<>();

        public void save(final Product product) {
            product.assignId(++sequence);
            persistence.put(product.getId(), product);
        }
    }
}
