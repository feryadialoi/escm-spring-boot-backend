package dev.feryadi.escm.mappersimpl;

import dev.feryadi.escm.entities.Merchant;
import dev.feryadi.escm.mappers.MerchantMapper;
import dev.feryadi.escm.models.MerchantResponse;
import org.springframework.stereotype.Component;

@Component
public class MerchantMapperImpl implements MerchantMapper {
    @Override
    public MerchantResponse mapMerchantToMerchantResponse(Merchant merchant) {
        MerchantResponse merchantResponse = new MerchantResponse();
        merchantResponse.setId(merchant.getId());
        merchantResponse.setName(merchant.getName());
        return merchantResponse;
    }
}
