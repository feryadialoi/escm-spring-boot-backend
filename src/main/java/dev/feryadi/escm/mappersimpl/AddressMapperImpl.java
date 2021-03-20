package dev.feryadi.escm.mappersimpl;

import dev.feryadi.escm.entities.Address;
import dev.feryadi.escm.mappers.AddressMapper;
import dev.feryadi.escm.models.AddressResponse;
import org.springframework.stereotype.Component;

@Component
public class AddressMapperImpl implements AddressMapper {
    @Override
    public AddressResponse mapAddressToAddressResponse(Address address) {
        AddressResponse addressResponse = new AddressResponse();
        addressResponse.setId(addressResponse.getId());
        addressResponse.setName(address.getName());
        return addressResponse;
    }
}
