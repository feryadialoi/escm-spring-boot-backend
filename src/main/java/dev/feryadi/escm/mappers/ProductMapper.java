package dev.feryadi.escm.mappers;

import dev.feryadi.escm.entities.Product;
import dev.feryadi.escm.models.ProductResponse;

public interface ProductMapper {
    ProductResponse mapProductToProductResponse(Product product);
}
