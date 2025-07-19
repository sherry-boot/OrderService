package com.example.OrderService.dto;

import com.example.OrderService.entity.OrderItems;
import com.example.OrderService.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO {
    private String userId;

    private Long orderId;

    private OrderStatus status;

    private List<OrderItemDTO> orderItems;

    private Double totalPrice;
}
