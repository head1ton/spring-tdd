package ai.springtest.product.controller;

import ai.springtest.product.domain.Product;
import ai.springtest.product.dto.AddProductRequest;
import ai.springtest.product.dto.GetProductResponse;
import ai.springtest.product.dto.UpdateProductRequest;
import ai.springtest.product.service.ProductPort;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductService {

    @Autowired
    private ProductPort productPort;

    @PostMapping("")
    @Transactional
    public ResponseEntity<Void> addProduct(@RequestBody final AddProductRequest request) {
        Product product = new Product(request.name(), request.price(),
            request.discountPolicy());

        productPort.save(product);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{productId}")
    public ResponseEntity<GetProductResponse> getProduct(
        @PathVariable(name = "productId") final Long productId) {
        final Product product = productPort.getProduct(productId);

        GetProductResponse getProductResponse = new GetProductResponse(
            product.getId(),
            product.getName(),
            product.getPrice(),
            product.getDiscountPolicy());

        return ResponseEntity.status(HttpStatus.OK)
                             .body(getProductResponse);
    }

    @PatchMapping("/{productId}")
    @Transactional
    public ResponseEntity<Void> updateProduct(
        @PathVariable(name = "productId") final Long productId,
        @RequestBody final UpdateProductRequest request) {
        Product product = productPort.getProduct(productId);
        product.update(request.name(), request.price(), request.discountPolicy());

        productPort.save(product);

        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
