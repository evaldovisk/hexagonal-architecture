package com.evaldovisk.hexagonal.adapters.in.controller;

import com.evaldovisk.hexagonal.adapters.in.controller.request.CustomerRequest;
import com.evaldovisk.hexagonal.adapters.in.controller.mapper.CustomerMapper;
import com.evaldovisk.hexagonal.adapters.in.controller.response.CustomerResponse;
import com.evaldovisk.hexagonal.application.core.domain.Customer;
import com.evaldovisk.hexagonal.application.ports.in.DeleteCustomerInputPort;
import com.evaldovisk.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.evaldovisk.hexagonal.application.ports.in.InsertCustomerInputPort;
import com.evaldovisk.hexagonal.application.ports.in.UpdateCustomerInputPort;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {

    private final InsertCustomerInputPort insertCustomerInputPort;

    private final FindCustomerByIdInputPort findCustomerByIdInputPort;

    private final UpdateCustomerInputPort updateCustomerInputPort;

    private final DeleteCustomerInputPort deleteCustomerInputPort;

    private final CustomerMapper customerMapper;

    public CustomerController(InsertCustomerInputPort insertCustomerInputPort,
                              FindCustomerByIdInputPort findCustomerByIdInputPort,
                              CustomerMapper customerMapper,
                              UpdateCustomerInputPort updateCustomerInputPort,
                              DeleteCustomerInputPort deleteCustomerInputPort) {
        this.insertCustomerInputPort = insertCustomerInputPort;
        this.findCustomerByIdInputPort = findCustomerByIdInputPort;
        this.customerMapper = customerMapper;
        this.updateCustomerInputPort = updateCustomerInputPort;
        this.deleteCustomerInputPort = deleteCustomerInputPort;
    }

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody CustomerRequest customerRequest) {
        Customer customer = customerMapper.toCustomer(customerRequest);
        insertCustomerInputPort.insert(customer, customerRequest.getZipCode());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> findById(@PathVariable("id") String id) {
        Customer customer = findCustomerByIdInputPort.find(id);
        return ResponseEntity.ok(customerMapper.toCustomerResponse(customer));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable String id, @Valid @RequestBody CustomerRequest customerRequest) {
        Customer customer = customerMapper.toCustomer(customerRequest);
        customer.setId(id);
        updateCustomerInputPort.update(customer, customerRequest.getZipCode());
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String id) {
        deleteCustomerInputPort.delete(id);
        return ResponseEntity.ok().build();
    }

}
