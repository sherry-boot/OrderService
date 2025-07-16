package com.example.OrderService.service;


import com.example.OrderService.dto.OrderRequestDTO;
import com.example.OrderService.dto.OrderResponseDTO;
import org.springframework.stereotype.Component;


public interface OrderInterfaceService {
    OrderResponseDTO createOrder(OrderRequestDTO orderRequestDTO);
}
