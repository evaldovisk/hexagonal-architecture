package com.evaldovisk.hexagonal.config;

import com.evaldovisk.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import com.evaldovisk.hexagonal.adapters.out.InsertCustomerAdapter;
import com.evaldovisk.hexagonal.adapters.out.SendCpfForValidationAdapter;
import com.evaldovisk.hexagonal.application.core.usecase.InsertCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertCustomerConfig {

    @Bean
    public InsertCustomerUseCase insertCustomerUseCase(
            FindAddressByZipCodeAdapter addressByZipCodeAdapter,
            InsertCustomerAdapter insertCustomerAdapter,
            SendCpfForValidationAdapter sendCpfForValidationAdapter) {
        return new InsertCustomerUseCase(addressByZipCodeAdapter, insertCustomerAdapter, sendCpfForValidationAdapter);
    }
}
