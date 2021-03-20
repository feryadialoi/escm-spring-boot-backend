package dev.feryadi.escm.mappers;

import dev.feryadi.escm.entities.Address;
import dev.feryadi.escm.models.AddressResponse;

public interface AddressMapper {
    AddressResponse mapAddressToAddressResponse(Address address);
}
