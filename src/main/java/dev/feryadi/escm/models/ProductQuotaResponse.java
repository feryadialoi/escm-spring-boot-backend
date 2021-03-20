package dev.feryadi.escm.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductQuotaResponse {
    private Long id;
    private Integer quota;
    private ProductResponse product;
    private MerchantResponse merchant;
}
