package dev.feryadi.escm.servicesimpl;

import dev.feryadi.escm.entities.Address;
import dev.feryadi.escm.entities.Merchant;
import dev.feryadi.escm.exceptions.NotFoundException;
import dev.feryadi.escm.mappers.AddressMapper;
import dev.feryadi.escm.models.AddressResponse;
import dev.feryadi.escm.models.CreateAddressRequest;
import dev.feryadi.escm.models.ListAddressRequest;
import dev.feryadi.escm.models.UpdateAddressRequest;
import dev.feryadi.escm.repositories.AddressRepository;
import dev.feryadi.escm.repositories.MerchantRepository;
import dev.feryadi.escm.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private AddressMapper addressMapper;
    @Autowired
    private MerchantRepository merchantRepository;

    @Override
    public List<AddressResponse> getAddresses(ListAddressRequest listAddressRequest) {
        return null;
    }

    @Override
    public AddressResponse getAddress(Long addressId) throws NotFoundException {
        Address address = findAddressByIdOrThrowNotFound(addressId);
        return addressMapper.mapAddressToAddressResponse(address);
    }

    @Transactional
    @Override
    public AddressResponse createAddress(CreateAddressRequest createAddressRequest) throws NotFoundException {
        Address address = new Address();
        address.setName(createAddressRequest.getName());

        Merchant merchant = findMerchantByIdOrThrowNotFound(createAddressRequest.getMerchantId());
        address.setMerchant(merchant);

        addressRepository.save(address);

        return addressMapper.mapAddressToAddressResponse(address);
    }

    @Transactional
    @Override
    public AddressResponse updateAddress(UpdateAddressRequest updateAddressRequest, Long addressId) throws NotFoundException {
        Address address = findAddressByIdOrThrowNotFound(addressId);
        if (updateAddressRequest.getName() != null) {
            address.setName(updateAddressRequest.getName());
        }

        addressRepository.save(address);

        return addressMapper.mapAddressToAddressResponse(address);

    }

    @Override
    public AddressResponse deleteAddress(Long addressId) throws NotFoundException {
        Address address = findAddressByIdOrThrowNotFound(addressId);
        addressRepository.delete(address);
        return addressMapper.mapAddressToAddressResponse(address);
    }

    private Merchant findMerchantByIdOrThrowNotFound(Long merchantId) throws NotFoundException {
        Optional<Merchant> optionalMerchant = merchantRepository.findById(merchantId);
        if (optionalMerchant.isPresent()) {
            return optionalMerchant.get();
        }
        throw new NotFoundException("merchant with specified id not found, merchant id = '" + merchantId + "'");
    }

    private Address findAddressByIdOrThrowNotFound(Long addressId) throws NotFoundException {
        Optional<Address> optionalAddress = addressRepository.findById(addressId);
        if (optionalAddress.isPresent()) {
            return optionalAddress.get();
        }
        throw new NotFoundException("address with specified id not found, address id = '" + addressId + "'");
    }

}
