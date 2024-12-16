package com.evaldovisk.hexagonal.application.ports.out;

public interface SendCpfForValidationOutPort {


    void send(String cpf);
}
