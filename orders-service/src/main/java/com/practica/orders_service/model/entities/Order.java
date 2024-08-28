package com.practica.orders_service.model.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name= "product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String orderNumber;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItems> orderItems;

}
