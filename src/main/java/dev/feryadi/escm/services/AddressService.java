package dev.feryadi.escm.services;

import dev.feryadi.escm.exceptions.NotFoundException;
import dev.feryadi.escm.models.AddressResponse;
import dev.feryadi.escm.models.CreateAddressRequest;
import dev.feryadi.escm.models.ListAddressRequest;
import dev.feryadi.escm.models.UpdateAddressRequest;

import java.util.List;

public interface AddressService {
    List<AddressResponse> getAddresses(ListAddressRequest listAddressRequest);
    AddressResponse getAddress(Long addressId) throws NotFoundException;
    AddressResponse createAddress(CreateAddressRequest createAddressRequest) throws NotFoundException;
    AddressResponse updateAddress(UpdateAddressRequest updateAddressRequest, Long addressId) throws NotFoundException;
    AddressResponse deleteAddress(Long addressId) throws NotFoundException;
}
