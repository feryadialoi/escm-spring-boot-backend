package dev.feryadi.escm.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaleOrderDetailRequest {
    private Integer quantity;
    private Long productId;
}
