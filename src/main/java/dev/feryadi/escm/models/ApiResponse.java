package dev.feryadi.escm.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResponse {
    private String message;
    private Integer status;

    public ApiResponse(String message, Integer status) {
        this.message = message;
        this.status = status;
    }
}
