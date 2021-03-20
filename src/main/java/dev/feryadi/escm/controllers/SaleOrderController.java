package dev.feryadi.escm.controllers;

import dev.feryadi.escm.models.ApiResponseSuccess;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "/api/v1/sale-orders")
public class SaleOrderController {
    @PostMapping("/")
    public ResponseEntity<ApiResponseSuccess<Object>> createSaleOrder() {

        return null;
    }
}
