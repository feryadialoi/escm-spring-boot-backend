package dev.feryadi.escm.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListMerchantRequest {
    private Integer page;
    private Integer size;

    public ListMerchantRequest(Integer page, Integer size) {
        this.page = page;
        this.size = size;
    }
}
