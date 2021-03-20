package dev.feryadi.escm.mappersimpl;

import dev.feryadi.escm.entities.ProductQuota;
import dev.feryadi.escm.mappers.MerchantMapper;
import dev.feryadi.escm.mappers.ProductMapper;
import dev.feryadi.escm.mappers.ProductQuotaMapper;
import dev.feryadi.escm.models.ProductQuotaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductQuotaMapperImpl implements ProductQuotaMapper {
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private MerchantMapper merchantMapper;

    @Override
    public ProductQuotaResponse mapProductQuotaToProductQuotaResponse(ProductQuota productQuota) {
        ProductQuotaResponse productQuotaResponse = new ProductQuotaResponse();
        productQuotaResponse.setId(productQuota.getId());
        productQuotaResponse.setQuota(productQuota.getQuota());
        productQuotaResponse.setProduct(productMapper.mapProductToProductResponse(productQuota.getProduct()));
        productQuotaResponse.setMerchant(merchantMapper.mapMerchantToMerchantResponse(productQuota.getMerchant()));
        return productQuotaResponse;
    }
}
