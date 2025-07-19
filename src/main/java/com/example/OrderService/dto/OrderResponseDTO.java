package com.example.OrderService.dto;

import com.example.OrderService.entity.Order;
import com.example.OrderService.entity.OrderItems;
import com.example.OrderService.enums.OrderStatus;
import lombok.*;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderResponseDTO {

    private OrderDTO order;
    private OrderStatus status;
    private Double totalPrice;
    private List<OrderItemDTO> itemDTOS;
}
