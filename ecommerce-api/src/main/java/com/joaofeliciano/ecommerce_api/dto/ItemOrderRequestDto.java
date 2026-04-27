package com.joaofeliciano.ecommerce_api.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ItemOrderRequestDto {

    @NotNull(message = "Id order is required.")
    private Long idOrder;

    @NotNull(message = "Id order is required.")
    private Long idProduct;

    @NotNull(message = "Quantity is required.")
    @Min(value = 1, message = "Quantity must be at least 1.")
    private Integer quantity;

}
