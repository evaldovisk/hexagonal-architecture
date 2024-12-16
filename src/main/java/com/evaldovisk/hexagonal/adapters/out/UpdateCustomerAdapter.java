package com.evaldovisk.hexagonal.adapters.out;

import com.evaldovisk.hexagonal.adapters.out.repository.CustomerRepository;
import com.evaldovisk.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.evaldovisk.hexagonal.application.core.domain.Customer;
import com.evaldovisk.hexagonal.application.ports.out.UpdateCustomerOutPort;
import org.springframework.stereotype.Component;

@Component
public class UpdateCustomerAdapter implements UpdateCustomerOutPort {


    private final CustomerRepository customerRepository;

    private final CustomerEntityMapper customerEntityMapper;

    public UpdateCustomerAdapter(CustomerRepository customerRepository,
                                 CustomerEntityMapper customerEntityMapper) {
        this.customerRepository = customerRepository;
        this.customerEntityMapper = customerEntityMapper;
    }

    @Override
    public void update(Customer customer) {
        customerRepository.save(customerEntityMapper.toCustomerEntity(customer));
    }
}
