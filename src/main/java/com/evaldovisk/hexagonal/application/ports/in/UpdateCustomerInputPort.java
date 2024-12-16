package com.evaldovisk.hexagonal.application.ports.in;

import com.evaldovisk.hexagonal.application.core.domain.Customer;
import org.springframework.stereotype.Component;

public interface UpdateCustomerInputPort {

    void update(Customer customer, String zipCode);

}
