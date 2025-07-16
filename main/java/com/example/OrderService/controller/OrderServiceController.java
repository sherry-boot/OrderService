package com.example.OrderService.controller;


import com.example.OrderService.dto.OrderRequestDTO;
import com.example.OrderService.dto.OrderResponseDTO;
import com.example.OrderService.service.OrderInterfaceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order")
public class OrderServiceController {

    private final OrderInterfaceService orderInterfaceService;
    OrderServiceController(OrderInterfaceService orderInterfaceService){
        this.orderInterfaceService = orderInterfaceService;
    }

    @PostMapping
    public OrderResponseDTO createOrder(@RequestBody OrderRequestDTO orderRequestDTO){
       OrderResponseDTO orderResponseDTO =  orderInterfaceService.createOrder(orderRequestDTO);
       return ResponseEntity.ok().body(orderResponseDTO).getBody();
    }

}
