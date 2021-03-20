package dev.feryadi.escm.services;

import dev.feryadi.escm.exceptions.NotFoundException;
import dev.feryadi.escm.models.CreateProductQuotaRequest;
import dev.feryadi.escm.models.ListProductQuota;
import dev.feryadi.escm.models.ProductQuotaResponse;
import dev.feryadi.escm.models.UpdateProductQuotaRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductQuotaService {
    List<ProductQuotaResponse> getProductQuotas(ListProductQuota listProductQuota);
    ProductQuotaResponse getProductQuota(Long productQuotaId) throws NotFoundException;
    ProductQuotaResponse createProductQuota(CreateProductQuotaRequest createProductQuotaRequest) throws NotFoundException;
    ProductQuotaResponse updateProductQuota(UpdateProductQuotaRequest updateProductQuotaRequest, Long productQuotaId) throws NotFoundException;
    ProductQuotaResponse deleteProductQuota(Long productQuotaId) throws NotFoundException;
}
