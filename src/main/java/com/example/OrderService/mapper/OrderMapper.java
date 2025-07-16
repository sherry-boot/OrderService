package com.example.OrderService.mapper;

import com.example.OrderService.dto.OrderRequestDTO;
import com.example.OrderService.dto.OrderResponseDTO;
import com.example.OrderService.entity.Order;
import com.example.OrderService.enums.OrderStatus;

public class OrderMapper {

    public static Order toEntity(OrderRequestDTO dto) {
        return Order.builder()
                .orderId(dto.getOrderId())
                .userId(dto.getUserId())
                .status(OrderStatus.PENDING)
                .build();
    }

    public static OrderResponseDTO toCreateOrderRepsonse(Order createdOrder) {
        return OrderResponseDTO.builder()
                .order(createdOrder)
                .status(createdOrder.getStatus())
                .build();
    }
}
