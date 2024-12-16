package com.evaldovisk.hexagonal.config;

import com.evaldovisk.hexagonal.adapters.out.DeleteCustomerByIdAdapter;
import com.evaldovisk.hexagonal.application.core.usecase.DeleteCustomerByIdUseCase;
import com.evaldovisk.hexagonal.application.core.usecase.FindCustomerByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteCustomerConfig {

    @Bean
    public DeleteCustomerByIdUseCase deleteCustomerByIdUseCase(
            FindCustomerByIdUseCase findCustomerByIdUseCase,
            DeleteCustomerByIdAdapter deleteCustomerByIdAdapter) {
        return new DeleteCustomerByIdUseCase(findCustomerByIdUseCase, deleteCustomerByIdAdapter);

    }

}
