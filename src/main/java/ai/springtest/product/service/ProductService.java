package ai.springtest.product.service;

import ai.springtest.product.domain.Product;
import ai.springtest.product.dto.AddProductRequest;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

    private final ProductPort productPort;

    public ProductService(final ProductPort productPort) {
        this.productPort = productPort;
    }

    @Transactional
    public void addProduct(final AddProductRequest request) {
        Product product = new Product(request.name(), request.price(),
            request.discountPolicy());

        productPort.save(product);
    }
}
