package com.example.OrderService.mapper;

import com.example.OrderService.dto.OrderDTO;
import com.example.OrderService.dto.OrderItemDTO;
import com.example.OrderService.dto.OrderRequestDTO;
import com.example.OrderService.dto.OrderResponseDTO;
import com.example.OrderService.entity.Order;
import com.example.OrderService.entity.OrderItems;
import com.example.OrderService.enums.OrderStatus;

import java.util.List;

public class OrderMapper {

    public static Order toEntity(OrderRequestDTO dto) {
//        Double sumi = 0.0;
//        Double totalPrice = orderItemsList.stream().mapToDouble(o->  (o.getTotalPrice())).sum();
        return Order.builder()
                .orderId(dto.getOrderId())
                .userId(dto.getUserId())
                .status(OrderStatus.PENDING)
                .build();
    }
    public static OrderDTO toDto(Order order) {
        return OrderDTO.builder()
                .orderId(order.getOrderId())
                .userId(order.getUserId())
                .status(OrderStatus.PENDING).totalPrice(order.getOrdertotalPrice())
                .build();
    }

    public static OrderResponseDTO toCreateOrderRepsonse(Order createdOrder) {
        OrderDTO orderDTO = toDto(createdOrder);

        List<OrderItemDTO> orderItemDTOList = createdOrder.getOrderItems().stream()
                .map(orderItems -> OrderItemDTO.builder()
                        .userId(orderItems.getUserId()).productId(orderItems.getProductId())
                        .quantity(orderItems.getQuantity()).pricePerUnit(orderItems.getPricePerUnit())
                        .totalPrice(orderItems.getTotalPrice())
                        .build()).toList();

        return OrderResponseDTO.builder()
                .order(orderDTO)
                .totalPrice(createdOrder.getOrdertotalPrice())
                .status(createdOrder.getStatus())
                .itemDTOS(orderItemDTOList)
                .build();
    }
}
