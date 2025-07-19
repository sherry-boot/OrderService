package com.example.OrderService.entity;

import com.example.OrderService.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "orders") // use plural table name to avoid SQL reserved keyword
public class Order extends BaseEntity {

    @Column(name = "user_id", nullable = false)
    private String userId;

    @Column(name = "order_id", unique = true)
    private Long orderId;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @Column(name = "total_price")
    private  Double OrdertotalPrice;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItems> orderItems;
}
