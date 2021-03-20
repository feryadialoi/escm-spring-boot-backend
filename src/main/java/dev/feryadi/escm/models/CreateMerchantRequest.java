package dev.feryadi.escm.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateMerchantRequest {
    private String name;
    private Long userId;
    private Long addressId;
}
