package dev.feryadi.escm.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductQuotaRequest {
    private Integer quota;
    private Long productId;
    private Long merchantId;
}
