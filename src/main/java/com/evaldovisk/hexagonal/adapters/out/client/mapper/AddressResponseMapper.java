package com.evaldovisk.hexagonal.adapters.out.client.mapper;

import com.evaldovisk.hexagonal.adapters.out.client.response.AddressResponse;
import com.evaldovisk.hexagonal.application.core.domain.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressResponseMapper {

    Address toAddress(AddressResponse addressResponse);

}
