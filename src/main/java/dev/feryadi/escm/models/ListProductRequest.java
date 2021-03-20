package dev.feryadi.escm.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListProductRequest {
    private Integer page;
    private Integer size;

    public ListProductRequest(Integer page, Integer size) {
        this.page = page;
        this.size = size;
    }
}
