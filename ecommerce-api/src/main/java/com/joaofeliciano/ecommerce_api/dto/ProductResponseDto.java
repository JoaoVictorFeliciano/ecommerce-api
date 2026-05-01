package com.joaofeliciano.ecommerce_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProductResponseDto {
    private Long idProduct;
    private String productName;
    private BigDecimal productPrice;
    private String description;
    private boolean active;
    private Integer quantityStock;
    private LocalDateTime creationDateProduct;
    private Long idCategory;
}
