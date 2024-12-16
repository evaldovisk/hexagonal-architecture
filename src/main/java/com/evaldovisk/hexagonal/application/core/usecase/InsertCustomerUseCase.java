package com.evaldovisk.hexagonal.application.core.usecase;

import com.evaldovisk.hexagonal.application.core.domain.Address;
import com.evaldovisk.hexagonal.application.core.domain.Customer;
import com.evaldovisk.hexagonal.application.ports.in.InsertCustomerInputPort;
import com.evaldovisk.hexagonal.application.ports.out.FindAddressByZipOutPort;
import com.evaldovisk.hexagonal.application.ports.out.InsertCustomerOutPort;
import com.evaldovisk.hexagonal.application.ports.out.SendCpfForValidationOutPort;

public class InsertCustomerUseCase implements InsertCustomerInputPort {

    private final FindAddressByZipOutPort findAddressByZipOutPort;

    private final InsertCustomerOutPort insertCustomerOutPort;

    private final SendCpfForValidationOutPort sendCpfForValidationOutPort;

    public InsertCustomerUseCase(FindAddressByZipOutPort findAddressByZipOutPort, InsertCustomerOutPort insertCustomerOutPort, SendCpfForValidationOutPort sendCpfForValidationOutPort) {
        this.findAddressByZipOutPort = findAddressByZipOutPort;
        this.insertCustomerOutPort = insertCustomerOutPort;
        this.sendCpfForValidationOutPort = sendCpfForValidationOutPort;
    }

    @Override
    public void insert(Customer customer, String zip) {
        Address address = findAddressByZipOutPort.findByZip(zip);
        customer.setAddress(address);
        insertCustomerOutPort.insertCustomer(customer);
        sendCpfForValidationOutPort.send(customer.getCpf());

    }
}
