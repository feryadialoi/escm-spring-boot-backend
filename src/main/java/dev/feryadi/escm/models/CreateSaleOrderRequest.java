package dev.feryadi.escm.models;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
public class CreateSaleOrderRequest {
    @NotNull
    private Long merchantId;

    @NotNull
    private List<SaleOrderDetailRequest> saleOrderDetailRequests;
}
