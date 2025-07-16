package com.example.OrderService.dto;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDTO {
    private  String name;

    private String image;

    private String color;

    private Double price;

    private String description;

    private String popular;

    private Double discount;

    private String model;

    private Long id;

    private String brand;

    private Long categoryId;

}
