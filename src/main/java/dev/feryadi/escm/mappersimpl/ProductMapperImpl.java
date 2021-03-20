package dev.feryadi.escm.mappersimpl;

import dev.feryadi.escm.entities.Product;
import dev.feryadi.escm.mappers.ProductMapper;
import dev.feryadi.escm.models.ProductResponse;
import org.springframework.stereotype.Component;

@Component
public class ProductMapperImpl implements ProductMapper {
    @Override
    public ProductResponse mapProductToProductResponse(Product product) {
        return null;
    }
}
