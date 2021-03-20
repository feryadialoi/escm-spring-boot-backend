package dev.feryadi.escm.controllers;

import dev.feryadi.escm.exceptions.NotFoundException;
import dev.feryadi.escm.models.*;
import dev.feryadi.escm.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/addresses")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @GetMapping
    public ResponseEntity<ApiResponseSuccess<List<AddressResponse>>> getAddresses(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "10") Integer size) {
        ListAddressRequest listAddressRequest = new ListAddressRequest(page, size);
        List<AddressResponse> addressResponses = addressService.getAddresses(listAddressRequest);
        ApiResponseSuccess<List<AddressResponse>> apiResponseSuccess = new ApiResponseSuccess<>("OK", 200, addressResponses);
        return new ResponseEntity<>(apiResponseSuccess, HttpStatus.OK);
    }

    @GetMapping("/{addressId}")
    public ResponseEntity<ApiResponseSuccess<AddressResponse>> getAddress(@PathVariable("addressId") Long addressId) throws NotFoundException {
        AddressResponse addressResponse = addressService.getAddress(addressId);
        ApiResponseSuccess<AddressResponse> apiResponseSuccess = new ApiResponseSuccess<>("OK", 200, addressResponse);
        return new ResponseEntity<>(apiResponseSuccess, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ApiResponseSuccess<AddressResponse>> createAddress(@RequestBody CreateAddressRequest createAddressRequest) throws NotFoundException {
        AddressResponse addressResponse = addressService.createAddress(createAddressRequest);
        ApiResponseSuccess<AddressResponse> apiResponseSuccess = new ApiResponseSuccess<>("CREATED", 201, addressResponse);
        return new ResponseEntity<>(apiResponseSuccess, HttpStatus.OK);
    }

    @PutMapping("/{addressId}")
    public ResponseEntity<ApiResponseSuccess<AddressResponse>> updateAddress(
            @RequestBody UpdateAddressRequest updateAddressRequest, @PathVariable("addressId") Long addressId) throws NotFoundException {
        AddressResponse addressResponse = addressService.updateAddress(updateAddressRequest, addressId);
        ApiResponseSuccess<AddressResponse> apiResponseSuccess = new ApiResponseSuccess<>("OK", 200, addressResponse);
        return new ResponseEntity<>(apiResponseSuccess, HttpStatus.OK);
    }

    @DeleteMapping("/{addressId}")
    public ResponseEntity<ApiResponseSuccess<AddressResponse>> deleteAddress(
            @PathVariable("addressId") Long addressId) throws NotFoundException {
        AddressResponse addressResponse = addressService.deleteAddress(addressId);
        ApiResponseSuccess<AddressResponse> apiResponseSuccess = new ApiResponseSuccess<>("OK", 200, addressResponse);
        return new ResponseEntity<>(apiResponseSuccess, HttpStatus.OK);
    }

}
