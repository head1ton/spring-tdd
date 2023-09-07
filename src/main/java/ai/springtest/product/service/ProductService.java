package ai.springtest.product.service;

import ai.springtest.product.domain.Product;
import ai.springtest.product.dto.AddProductRequest;

public class ProductService {

    private final ProductPort productPort;

    public ProductService(final ProductPort productPort) {
        this.productPort = productPort;
    }

    public void addProduct(final AddProductRequest request) {
        Product product = new Product(request.name(), request.price(),
            request.discountPolicy());

        productPort.save(product);
    }
}
