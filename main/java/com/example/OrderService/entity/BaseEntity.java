package com.example.OrderService.entity;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @CreatedDate
    private Instant createdAt;


    @LastModifiedDate
    private  Instant modifiedAt;


    @PrePersist
    protected void onCreate(){

        createdAt = Instant.now();
        modifiedAt = Instant.now();

    }

    @PreUpdate
    protected void onUpdate(){
        modifiedAt = Instant.now();
    }
}
