package com.evaldovisk.hexagonal.adapters.out;

import com.evaldovisk.hexagonal.adapters.out.client.FindAddressByZipCodeClient;
import com.evaldovisk.hexagonal.adapters.out.client.mapper.AddressResponseMapper;
import com.evaldovisk.hexagonal.adapters.out.client.response.AddressResponse;
import com.evaldovisk.hexagonal.application.core.domain.Address;
import com.evaldovisk.hexagonal.application.ports.out.FindAddressByZipOutPort;
import org.springframework.stereotype.Component;

@Component
public class FindAddressByZipCodeAdapter implements FindAddressByZipOutPort {

    private final FindAddressByZipCodeClient findAddressByZipCodeClient;

    private final AddressResponseMapper addressResponseMapper;

    public FindAddressByZipCodeAdapter(FindAddressByZipCodeClient findAddressByZipCodeClient, AddressResponseMapper addressResponseMapper) {
        this.findAddressByZipCodeClient = findAddressByZipCodeClient;
        this.addressResponseMapper = addressResponseMapper;
    }

    @Override
    public Address findByZip(String zip) {
        AddressResponse addressResponse = findAddressByZipCodeClient.findAddressByZipCode(zip);
        return addressResponseMapper.toAddress(addressResponse);
    }
}
