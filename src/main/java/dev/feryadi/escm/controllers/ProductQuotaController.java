package dev.feryadi.escm.controllers;

import dev.feryadi.escm.exceptions.NotFoundException;
import dev.feryadi.escm.models.*;
import dev.feryadi.escm.services.ProductQuotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product-quotas")
public class ProductQuotaController {
    @Autowired
    private ProductQuotaService productQuotaService;

    @GetMapping
    public ResponseEntity<ApiResponseSuccess<List<ProductQuotaResponse>>> getProductQuotas(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size) {
        ListProductQuota listProductQuota = new ListProductQuota(page, size);
        List<ProductQuotaResponse> productQuotaResponses = productQuotaService.getProductQuotas(listProductQuota);
        ApiResponseSuccess<List<ProductQuotaResponse>> apiResponseSuccess = new ApiResponseSuccess<>("OK", 200, productQuotaResponses);
        return new ResponseEntity<>(apiResponseSuccess, HttpStatus.OK);
    }

    @GetMapping("/{productQuotaId}")
    public ResponseEntity<ApiResponseSuccess<ProductQuotaResponse>> getProductQuota(
            @PathVariable("productQuotaId") Long productQuotaId) throws NotFoundException {
        ProductQuotaResponse productQuotaResponse = productQuotaService.getProductQuota(productQuotaId);
        ApiResponseSuccess<ProductQuotaResponse> apiResponseSuccess = new ApiResponseSuccess<>("OK", 200, productQuotaResponse);
        return new ResponseEntity<>(apiResponseSuccess, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ApiResponseSuccess<ProductQuotaResponse>> createProductQuota(
            @RequestBody CreateProductQuotaRequest createProductQuotaRequest) throws NotFoundException {
        ProductQuotaResponse productQuotaResponse = productQuotaService.createProductQuota(createProductQuotaRequest);
        ApiResponseSuccess<ProductQuotaResponse> apiResponseSuccess = new ApiResponseSuccess<>("CREATED", 201, productQuotaResponse);
        return new ResponseEntity<>(apiResponseSuccess, HttpStatus.CREATED);
    }

    @PutMapping("/{productQuotaId}")
    public ResponseEntity<ApiResponseSuccess<ProductQuotaResponse>> updateProductQuota(
            @RequestBody UpdateProductQuotaRequest updateProductQuotaRequest,
            @PathVariable("productQuotaId") Long productQuotaId) throws NotFoundException {
        ProductQuotaResponse productQuotaResponse = productQuotaService.updateProductQuota(updateProductQuotaRequest, productQuotaId);
        ApiResponseSuccess<ProductQuotaResponse> apiResponseSuccess = new ApiResponseSuccess<>("OK", 200, productQuotaResponse);
        return new ResponseEntity<>(apiResponseSuccess, HttpStatus.OK);
    }

    @DeleteMapping("/{productQuotaId}")
    public ResponseEntity<ApiResponseSuccess<ProductQuotaResponse>> deleteProductQuota(
            @PathVariable("productQuotaId") Long productQuotaId) throws NotFoundException {
        ProductQuotaResponse productQuotaResponse = productQuotaService.deleteProductQuota(productQuotaId);
        ApiResponseSuccess<ProductQuotaResponse> apiResponseSuccess = new ApiResponseSuccess<>("OK", 200, productQuotaResponse);
        return new ResponseEntity<>(apiResponseSuccess, HttpStatus.OK);
    }
}
