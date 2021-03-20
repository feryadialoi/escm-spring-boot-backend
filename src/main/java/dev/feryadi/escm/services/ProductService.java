package dev.feryadi.escm.services;

import dev.feryadi.escm.exceptions.NotFoundException;
import dev.feryadi.escm.models.CreateProductRequest;
import dev.feryadi.escm.models.ListProductRequest;
import dev.feryadi.escm.models.ProductResponse;
import dev.feryadi.escm.models.UpdateProductRequest;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService {
    List<ProductResponse> getProducts(ListProductRequest listProductRequest);
    ProductResponse getProduct(Long productId) throws NotFoundException;
    ProductResponse createProduct(CreateProductRequest createProductRequest);
    ProductResponse updateProduct(UpdateProductRequest updateProductRequest, Long productId) throws NotFoundException;
    ProductResponse deleteProduct(Long productId) throws NotFoundException;
}
