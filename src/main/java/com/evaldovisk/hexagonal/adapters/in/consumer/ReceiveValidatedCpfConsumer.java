package com.evaldovisk.hexagonal.adapters.in.consumer;

import com.evaldovisk.hexagonal.adapters.in.consumer.mapper.CustomerMessageMapper;
import com.evaldovisk.hexagonal.adapters.in.consumer.message.CustomerMessage;
import com.evaldovisk.hexagonal.application.core.domain.Customer;
import com.evaldovisk.hexagonal.application.ports.in.UpdateCustomerInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ReceiveValidatedCpfConsumer {

    @Autowired
    private UpdateCustomerInputPort updateCustomerInputPort;

    @Autowired
    private CustomerMessageMapper customerMessageMapper;

    @KafkaListener(topics = "tp-cpf-validated", groupId = "evaldovisk-hexagonal")
    public void receive(CustomerMessage customerMessage) {
        Customer customer = customerMessageMapper.toCustomer(customerMessage);

        System.out.println(customerMessage.toString());
        System.out.println(customer.getIsValidCpf());
        updateCustomerInputPort.update(customer, customerMessage.getZipCode());
    }

}