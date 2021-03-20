package dev.feryadi.escm.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaleOrderResponse {
    private Long id;

    public SaleOrderResponse(Long id) {
        this.id = id;
    }
}
