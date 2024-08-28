package com.practica.products_service.services;

import com.practica.products_service.model.dtos.ProductRequest;
import com.practica.products_service.model.dtos.ProductResponse;
import com.practica.products_service.model.entities.Product;
import com.practica.products_service.repositories.ProductRespository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRespository productRespository;

    public void addProduct (ProductRequest productRequest){
        var product = Product.builder()
                .sku(productRequest.getSku())
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .status(productRequest.getStatus())
                .build();

        productRespository.save(product);

        log.info("Product added: {}", product);

    }

    public List<ProductResponse> getAllProducts(){
        var products = productRespository.findAll();

        return products.stream().map(this::mapToProductResponse).toList();
    }

    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .sku(product.getSku())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .status(product.getStatus())
                .build();

    }
}
