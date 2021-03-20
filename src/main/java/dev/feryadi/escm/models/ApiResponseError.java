package dev.feryadi.escm.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResponseError<E> extends ApiResponse {
    private E error;

    public ApiResponseError(String message, Integer status, E error) {
        super(message, status);
        this.error = error;
    }
}
