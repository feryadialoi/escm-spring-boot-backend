package dev.feryadi.escm.mappersimpl;

import dev.feryadi.escm.entities.SaleOrder;
import dev.feryadi.escm.mappers.SaleOrderMapper;
import dev.feryadi.escm.models.SaleOrderResponse;
import org.springframework.stereotype.Component;

@Component
public class SaleOrderMapperImpl implements SaleOrderMapper {
    public SaleOrderResponse mapSaleOrderToSaleOrderResponse(SaleOrder saleOrder) {
        return new SaleOrderResponse(saleOrder.getId());
    }
}
