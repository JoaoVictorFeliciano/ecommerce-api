package com.joaofeliciano.ecommerce_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ItemOrderResponseDto {
    private Long idItemOrder;
    private Long idOrder;
    private Long idProduct;
    private Integer quantity;
    private BigDecimal unitaryPrice;
}
