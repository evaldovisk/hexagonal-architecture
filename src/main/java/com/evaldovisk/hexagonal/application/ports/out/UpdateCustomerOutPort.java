package com.evaldovisk.hexagonal.application.ports.out;

import com.evaldovisk.hexagonal.application.core.domain.Customer;

public interface UpdateCustomerOutPort {

    void update(Customer customer);

}
