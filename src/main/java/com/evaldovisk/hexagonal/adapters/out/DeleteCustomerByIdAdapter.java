package com.evaldovisk.hexagonal.adapters.out;

import com.evaldovisk.hexagonal.adapters.out.repository.CustomerRepository;
import com.evaldovisk.hexagonal.application.ports.out.DeleteCustomerByIdOutPort;
import org.springframework.stereotype.Component;

@Component
public class DeleteCustomerByIdAdapter implements DeleteCustomerByIdOutPort {

    private final CustomerRepository customerRepository;

    public DeleteCustomerByIdAdapter(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void delete(String id) {
        customerRepository.deleteById(id);
    }
}
