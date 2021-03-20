package dev.feryadi.escm.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ListRequest {
    private Integer page;
    private Integer size;
}
