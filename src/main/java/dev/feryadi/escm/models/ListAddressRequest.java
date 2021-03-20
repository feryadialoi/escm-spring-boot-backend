package dev.feryadi.escm.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListAddressRequest {
    private Integer page;
    private Integer size;

    public ListAddressRequest(Integer page, Integer size){
        this.page = page;
        this.size = size;
    }
}
