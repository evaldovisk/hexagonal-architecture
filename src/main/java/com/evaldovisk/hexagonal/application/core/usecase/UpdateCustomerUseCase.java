package com.evaldovisk.hexagonal.application.core.usecase;

import com.evaldovisk.hexagonal.application.core.domain.Address;
import com.evaldovisk.hexagonal.application.core.domain.Customer;
import com.evaldovisk.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.evaldovisk.hexagonal.application.ports.in.UpdateCustomerInputPort;
import com.evaldovisk.hexagonal.application.ports.out.FindAddressByZipOutPort;
import com.evaldovisk.hexagonal.application.ports.out.UpdateCustomerOutPort;

public class UpdateCustomerUseCase implements UpdateCustomerInputPort {

    private final FindCustomerByIdInputPort findCustomerByIdInputPort;

    private final FindAddressByZipOutPort findAddressByZipOutPort;

    private final UpdateCustomerOutPort updateCustomerOutPort;

    public UpdateCustomerUseCase(FindCustomerByIdInputPort findCustomerByIdInputPort,
                                 FindAddressByZipOutPort findAddressByZipOutPort,
                                 UpdateCustomerOutPort updateCustomerOutPort) {
        this.findCustomerByIdInputPort = findCustomerByIdInputPort;
        this.findAddressByZipOutPort = findAddressByZipOutPort;
        this.updateCustomerOutPort = updateCustomerOutPort;
    }

    @Override
    public void update(Customer customer, String zipCode) {
        findCustomerByIdInputPort.find(customer.getId());
        Address address = findAddressByZipOutPort.findByZip(zipCode);
        customer.setAddress(address);
        updateCustomerOutPort.update(customer);

    }
}
