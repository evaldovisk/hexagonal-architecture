package com.evaldovisk.hexagonal.adapters.out;

import com.evaldovisk.hexagonal.adapters.out.repository.CustomerRepository;
import com.evaldovisk.hexagonal.adapters.out.repository.entity.CustomerEntity;
import com.evaldovisk.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.evaldovisk.hexagonal.application.core.domain.Customer;
import com.evaldovisk.hexagonal.application.ports.out.InsertCustomerOutPort;
import org.springframework.stereotype.Component;

@Component
public class InsertCustomerAdapter implements InsertCustomerOutPort {

    private final CustomerRepository customerRepository;

    private final CustomerEntityMapper customerEntityMapper;


    public InsertCustomerAdapter(CustomerRepository customerRepository, CustomerEntityMapper customerEntityMapper) {
        this.customerRepository = customerRepository;
        this.customerEntityMapper = customerEntityMapper;
    }

    @Override
    public void insertCustomer(Customer customer) {
        CustomerEntity customerEntity = customerEntityMapper.toCustomerEntity(customer);
        System.out.println(customerEntity.toString());
        customerRepository.save(customerEntity);
    }
}
