package ai.springtest.product.service;

import ai.springtest.product.domain.Product;
import ai.springtest.product.respository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductAdapter implements ProductPort {

    private final ProductRepository productRepository;

    public ProductAdapter(final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void save(final Product product) {
        productRepository.save(product);
    }

    @Override
    public Product getProduct(final Long productId) {
        return productRepository.findById(productId)
                                .orElseThrow(() -> new IllegalArgumentException("상품이 존재하지 않습니다."));
    }
}
