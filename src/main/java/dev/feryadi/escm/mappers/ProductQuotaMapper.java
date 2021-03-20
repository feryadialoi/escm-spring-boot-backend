package dev.feryadi.escm.mappers;

import dev.feryadi.escm.entities.ProductQuota;
import dev.feryadi.escm.models.ProductQuotaResponse;

public interface ProductQuotaMapper {
    ProductQuotaResponse mapProductQuotaToProductQuotaResponse(ProductQuota productQuota);
}
