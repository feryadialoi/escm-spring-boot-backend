package dev.feryadi.escm.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateAddressRequest {
    private String name;
    private Long merchantId;
}
