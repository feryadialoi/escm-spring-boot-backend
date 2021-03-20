package dev.feryadi.escm.models;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
public class CreateProductRequest {
    @NotBlank
    private String name;

    @NotNull
    @Min(value = 1)
    private Integer quantity;

    @NotNull
    private BigDecimal price;
}
