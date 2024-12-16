package com.evaldovisk.hexagonal.application.ports.in;

import com.evaldovisk.hexagonal.application.core.domain.Customer;
import org.springframework.stereotype.Component;

@Component
public interface FindCustomerByIdInputPort {

    Customer find(String id);

}
