package dev.feryadi.escm.mappers;

import dev.feryadi.escm.entities.SaleOrder;
import dev.feryadi.escm.models.SaleOrderResponse;

public interface SaleOrderMapper {
    SaleOrderResponse mapSaleOrderToSaleOrderResponse(SaleOrder saleOrder);
}
