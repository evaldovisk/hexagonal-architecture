package com.evaldovisk.hexagonal.application.ports.out;

import com.evaldovisk.hexagonal.application.core.domain.Address;

public interface FindAddressByZipOutPort {

    Address findByZip(String zip);
}
