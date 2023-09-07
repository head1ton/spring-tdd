package ai.springtest.product.service;

import ai.springtest.product.domain.Product;

public interface ProductPort {

    void save(final Product product);
}
