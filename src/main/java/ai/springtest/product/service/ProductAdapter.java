package ai.springtest.product.service;

import ai.springtest.product.domain.Product;
import ai.springtest.product.respository.ProductRepository;

public class ProductAdapter implements ProductPort {

    private final ProductRepository productRepository;

    public ProductAdapter(final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void save(final Product product) {
        productRepository.save(product);
    }
}
