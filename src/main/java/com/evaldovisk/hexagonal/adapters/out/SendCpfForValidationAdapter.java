package com.evaldovisk.hexagonal.adapters.out;

import com.evaldovisk.hexagonal.application.ports.out.SendCpfForValidationOutPort;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class SendCpfForValidationAdapter implements SendCpfForValidationOutPort {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public SendCpfForValidationAdapter(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void send(String cpf) {
        kafkaTemplate.send("tp-cpf-validation", cpf);
    }
}
