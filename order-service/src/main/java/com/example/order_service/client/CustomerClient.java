package com.example.orderservice.client;

import com.microcommerce.orderservice.model.CustomerDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// Remplace l'URL par celle de ton customer-service si différente
@FeignClient(name = "customer-service", url = "http://localhost:8082")
public interface CustomerClient {

    @GetMapping("/api/customers/{id}")
    CustomerDTO getCustomerById(@PathVariable Long id);
}
