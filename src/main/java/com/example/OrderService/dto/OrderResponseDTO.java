package com.example.OrderService.dto;

import com.example.OrderService.entity.Order;
import com.example.OrderService.enums.OrderStatus;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderResponseDTO {

    private Order order;
    private OrderStatus status;
}
