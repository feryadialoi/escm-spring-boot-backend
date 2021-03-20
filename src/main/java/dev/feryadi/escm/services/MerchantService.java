package dev.feryadi.escm.services;

import dev.feryadi.escm.models.CreateMerchantRequest;
import dev.feryadi.escm.models.ListMerchantRequest;
import dev.feryadi.escm.models.MerchantResponse;

import java.util.List;

public interface MerchantService {
    List<MerchantResponse> getMerchants(ListMerchantRequest listMerchantRequest);
    MerchantResponse getMerchant(Long merchantId);
    MerchantResponse createMerchant(CreateMerchantRequest createMerchantRequest);
}
