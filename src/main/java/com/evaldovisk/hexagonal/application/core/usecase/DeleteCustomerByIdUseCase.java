package com.evaldovisk.hexagonal.application.core.usecase;

import com.evaldovisk.hexagonal.application.ports.in.DeleteCustomerInputPort;
import com.evaldovisk.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.evaldovisk.hexagonal.application.ports.out.DeleteCustomerByIdOutPort;

public class DeleteCustomerByIdUseCase implements DeleteCustomerInputPort {

    private final FindCustomerByIdInputPort findCustomerByIdInputPort;

    private final DeleteCustomerByIdOutPort deleteCustomerByIdOutPort;

    public DeleteCustomerByIdUseCase(FindCustomerByIdInputPort findCustomerByIdInputPort,
                                     DeleteCustomerByIdOutPort deleteCustomerByIdOutPort) {
        this.findCustomerByIdInputPort = findCustomerByIdInputPort;
        this.deleteCustomerByIdOutPort = deleteCustomerByIdOutPort;
    }

    @Override
    public void delete(String id) {
        findCustomerByIdInputPort.find(id);
        deleteCustomerByIdOutPort.delete(id);
    }

}
