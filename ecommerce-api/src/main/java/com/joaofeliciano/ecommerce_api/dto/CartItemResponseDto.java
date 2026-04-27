package com.joaofeliciano.ecommerce_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CartItemResponseDto {
    private Long idItemCart;
    private Long idCart;
    private Long idProduct;
    private Integer quantity;
    private BigDecimal unitaryPrice;
}
