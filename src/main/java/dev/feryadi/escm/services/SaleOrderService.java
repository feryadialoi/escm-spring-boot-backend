package dev.feryadi.escm.services;

import dev.feryadi.escm.models.CreateSaleOrderRequest;
import dev.feryadi.escm.models.SaleOrderResponse;
import org.springframework.stereotype.Service;

public interface SaleOrderService {
    SaleOrderResponse createSaleOrder(CreateSaleOrderRequest createSaleOrderRequest) throws Exception;
}
