package com.evaldovisk.hexagonal.application.ports.in;

import org.springframework.stereotype.Component;

public interface DeleteCustomerInputPort {

    public void delete(String id);

}
