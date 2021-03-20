package dev.feryadi.escm.models;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class UpdateProductRequest {
    private String name;
    private Integer quantity;
    private BigDecimal price;
}
