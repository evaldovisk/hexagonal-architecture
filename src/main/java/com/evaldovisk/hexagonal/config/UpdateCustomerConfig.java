package com.evaldovisk.hexagonal.config;

import com.evaldovisk.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import com.evaldovisk.hexagonal.adapters.out.UpdateCustomerAdapter;
import com.evaldovisk.hexagonal.application.core.usecase.FindCustomerByIdUseCase;
import com.evaldovisk.hexagonal.application.core.usecase.UpdateCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateCustomerConfig {

    @Bean
    public UpdateCustomerUseCase updateCustomerUseCase(
            FindCustomerByIdUseCase findCustomerByIdUseCase,
            FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
            UpdateCustomerAdapter updateCustomerAdapter) {
        return new UpdateCustomerUseCase(findCustomerByIdUseCase, findAddressByZipCodeAdapter, updateCustomerAdapter);
    }
}
