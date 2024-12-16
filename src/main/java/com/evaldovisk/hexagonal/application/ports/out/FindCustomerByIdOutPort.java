package com.evaldovisk.hexagonal.application.ports.out;

import com.evaldovisk.hexagonal.application.core.domain.Customer;

import java.util.Optional;

public interface FindCustomerByIdOutPort {

    Optional<Customer> find(String id);

}
