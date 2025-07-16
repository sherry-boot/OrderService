package com.example.OrderService.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "order_items")
public class OrderItems extends BaseEntity {

    @Column(name = "user_id")
    private String userId;

    @Column(name = "price_per_unit")
    private Double pricePerUnit;

    @Column(name = "quantity")
    private Long quantity;

    @Column(name = "p_id")
    private Long productId;

    @Column(name = "total_price")
    private Double totalPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;
}
