package dev.feryadi.escm.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateProductQuotaRequest {
    private Integer quota;
    private Long merchantId;
    private Long productId;
}
