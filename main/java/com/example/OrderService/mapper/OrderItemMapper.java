package com.example.OrderService.mapper;

import com.example.OrderService.dto.OrderItemDTO;
import com.example.OrderService.entity.Order;
import com.example.OrderService.entity.OrderItems;

import java.util.List;
import java.util.stream.Collectors;

public class OrderItemMapper {

    public static List<OrderItems> toListOfOrderItems(List<OrderItemDTO> itemDTOs) {
        return itemDTOs.stream()
                .map(dto -> OrderItems.builder()
                        .pricePerUnit(dto.getPricePerUnit())
                        .productId(dto.getProductId())
                        .quantity(dto.getQuantity())
                        .userId(dto.getUserId())
                        .build())
                .collect(Collectors.toList());
    }

    public static OrderItems toEntityFromList(OrderItems item, Long productId, Double totalPrice, Order order) {
        return OrderItems.builder()
                .userId(item.getUserId())
                .quantity(item.getQuantity())
                .pricePerUnit(item.getPricePerUnit())
                .productId(productId)
                .totalPrice(totalPrice)
                .order(order)
                .build();
    }
}
