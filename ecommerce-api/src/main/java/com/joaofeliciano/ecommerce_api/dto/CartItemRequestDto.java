package com.joaofeliciano.ecommerce_api.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CartItemRequestDto {

    @NotNull(message = "Cart is required.")
    private Long idCart;

    @NotNull(message = "Product is required.")
    private Long idProduct;

    @NotNull(message = "Quantity is required.")
    @Min(value = 1, message = "Quantity must be at least 1.")
    private Integer quantity;

}
