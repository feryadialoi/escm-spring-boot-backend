package dev.feryadi.escm.controllers;

import dev.feryadi.escm.exceptions.NotFoundException;
import dev.feryadi.escm.models.*;
import dev.feryadi.escm.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<ApiResponseSuccess<List<ProductResponse>>> getProducts(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size) {
        ListProductRequest listProductRequest = new ListProductRequest(page,size);
        List<ProductResponse> productResponses = productService.getProducts(listProductRequest);
        ApiResponseSuccess<List<ProductResponse>> apiResponseSuccess = new ApiResponseSuccess<>("OK",200, productResponses);
        return new ResponseEntity<>(apiResponseSuccess, HttpStatus.OK);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ApiResponseSuccess<ProductResponse>> getProduct(
            @PathVariable("productId") Long productId) throws NotFoundException {
        ProductResponse productResponse = productService.getProduct(productId);
        ApiResponseSuccess<ProductResponse> apiResponseSuccess = new ApiResponseSuccess<>("OK", 200, productResponse);
        return new ResponseEntity<>(apiResponseSuccess, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ApiResponseSuccess<ProductResponse>> createProduct(
            @Valid @RequestBody CreateProductRequest createProductRequest) {
        ProductResponse productResponse = productService.createProduct(createProductRequest);
        ApiResponseSuccess<ProductResponse> apiResponseSuccess = new ApiResponseSuccess<>("OK", 201, productResponse);
        return new ResponseEntity<>(apiResponseSuccess, HttpStatus.OK);
    }

    @PutMapping("/{productId}")
    public ResponseEntity<ApiResponseSuccess<ProductResponse>> updateProduct(
            @RequestBody UpdateProductRequest updateProductRequest,
            @PathVariable("productId") Long productId) throws NotFoundException {
        ProductResponse productResponse = productService.updateProduct(updateProductRequest, productId);
        ApiResponseSuccess<ProductResponse> apiResponseSuccess = new ApiResponseSuccess<>("OK", 200, productResponse);
        return new ResponseEntity<>(apiResponseSuccess, HttpStatus.OK);
    }

}
