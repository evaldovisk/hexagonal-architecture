package com.evaldovisk.hexagonal.application.core.usecase;

import com.evaldovisk.hexagonal.application.core.domain.Customer;
import com.evaldovisk.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.evaldovisk.hexagonal.application.ports.out.FindCustomerByIdOutPort;

public class FindCustomerByIdUseCase implements FindCustomerByIdInputPort {

    private final FindCustomerByIdOutPort findCustomerByIdOutPort;

    public FindCustomerByIdUseCase(FindCustomerByIdOutPort findCustomerByIdOutPort) {
        this.findCustomerByIdOutPort = findCustomerByIdOutPort;
    }

    @Override
    public Customer find(String id) {
        return findCustomerByIdOutPort.find(id)
                .orElseThrow(() -> new RuntimeException("Customer Not Found"));
    }

}
