package com.example.orderservice.service;

import com.microcommerce.orderservice.client.CustomerClient;
import com.microcommerce.orderservice.model.CustomerDTO;
import com.microcommerce.orderservice.model.Order;
import com.microcommerce.orderservice.model.OrderWithCustomerDetails;
import com.microcommerce.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final CustomerClient customerClient;

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    public OrderWithCustomerDetails getOrderWithCustomer(Long orderId) {
        Order order = getOrderById(orderId);
        if (order == null) {
            return null;
        }

        CustomerDTO customer = customerClient.getCustomerById(order.getCustomerId());

        OrderWithCustomerDetails details = new OrderWithCustomerDetails();
        details.setOrder(order);
        details.setCustomer(customer);

        return details;
    }
}
