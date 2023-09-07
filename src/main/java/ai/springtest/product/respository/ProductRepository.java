package ai.springtest.product.respository;

import ai.springtest.product.domain.Product;
import java.util.HashMap;
import java.util.Map;

public class ProductRepository {

    private final Map<Long, Product> persistence = new HashMap<>();
    private Long sequence = 0L;

    public void save(final Product product) {
        product.assignId(++sequence);
        persistence.put(product.getId(), product);
    }
}
