package com.evaldovisk.hexagonal.adapters.in.controller.response;

import com.evaldovisk.hexagonal.adapters.out.client.response.AddressResponse;
import lombok.Data;

@Data
public class CustomerResponse {
    private String name;
    private AddressResponse address;
    private String cpf;
    private Boolean isValidCpf;

}
