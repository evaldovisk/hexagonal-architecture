package com.evaldovisk.hexagonal.adapters.out;

import com.evaldovisk.hexagonal.adapters.out.repository.CustomerRepository;
import com.evaldovisk.hexagonal.adapters.out.repository.entity.CustomerEntity;
import com.evaldovisk.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.evaldovisk.hexagonal.application.core.domain.Customer;
import com.evaldovisk.hexagonal.application.ports.out.FindCustomerByIdOutPort;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindCustomerByIdAdapter implements FindCustomerByIdOutPort {

    private final CustomerRepository customerRepository;

    private final CustomerEntityMapper customerEntityMapper;

    public FindCustomerByIdAdapter(CustomerRepository customerRepository, CustomerEntityMapper customerEntityMapper) {
        this.customerRepository = customerRepository;
        this.customerEntityMapper = customerEntityMapper;
    }

    @Override
    public Optional<Customer> find(String id) {
        Optional<CustomerEntity> customerEntity = customerRepository.findById(id);
        return customerEntity.map(customerEntityMapper::toCustomer);
    }
}
