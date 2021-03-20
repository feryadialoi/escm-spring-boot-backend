package dev.feryadi.escm.mappers;

import dev.feryadi.escm.entities.Merchant;
import dev.feryadi.escm.models.MerchantResponse;

public interface MerchantMapper {
    MerchantResponse mapMerchantToMerchantResponse(Merchant merchant);
}
