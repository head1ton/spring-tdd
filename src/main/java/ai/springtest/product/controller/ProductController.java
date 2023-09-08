package ai.springtest.product.controller;

import ai.springtest.product.dto.AddProductRequest;
import ai.springtest.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("")
    public ResponseEntity<Void> addProduct(
        @RequestBody final AddProductRequest request
    ) {
        productService.addProduct(request);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}