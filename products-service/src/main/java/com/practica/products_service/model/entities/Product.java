package com.practica.products_service.model.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name= "product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String sku; // code used to identify products
    private String name;
    private String description;
    private Double price;
    private Boolean status;

    @Override
    public String toString(){
        return "Product{" +
               "id=" + id +
               "name='" + name + '\'' +
               ", description='" + description + '\'' +
               '}';
    }
}
