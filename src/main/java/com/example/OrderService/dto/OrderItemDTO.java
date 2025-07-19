package com.example.OrderService.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderItemDTO {

    private  Long productId;
    private Long quantity;
    private Double pricePerUnit;
    private  String userId;
    private Double totalPrice;
}
