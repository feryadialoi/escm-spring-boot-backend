package dev.feryadi.escm.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResponseSuccess<D> extends ApiResponse {
    private D data;

    public ApiResponseSuccess(String message, Integer status, D data) {
        super(message, status);
        this.data = data;
    }
}
