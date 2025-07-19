package com.example.OrderService.mapper;

import com.example.OrderService.dto.OrderItemDTO;
import com.example.OrderService.dto.ProductDTO;
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

    public static OrderItems toEntityFromList(OrderItems item, Long productId, Double totalPrice, Double price, Order order) {

        //        Double sumi = 0.0;
        return OrderItems.builder()
                .userId(item.getUserId())
                .quantity(item.getQuantity())
                .pricePerUnit(price)
                .productId(productId)
                .totalPrice(totalPrice).order(order)
                .order(order)
                .build();
    }
}
