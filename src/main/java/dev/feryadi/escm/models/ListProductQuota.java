package dev.feryadi.escm.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListProductQuota {
    private Integer page;
    private Integer size;

    public ListProductQuota(Integer page, Integer size) {
        this.page = page;
        this.size = size;
    }
}
