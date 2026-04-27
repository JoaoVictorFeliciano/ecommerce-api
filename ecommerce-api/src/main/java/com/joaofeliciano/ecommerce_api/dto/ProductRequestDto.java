package com.joaofeliciano.ecommerce_api.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProductRequestDto {

    @NotBlank(message = "Product name is required.")
    @Size(max = 150, message = "Product name must have at most 150 characters")
    private String productName;

    @NotBlank(message = "Description of the product is required.")
    private String description;

    @NotNull(message = "Price is required.")
    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than zero.")
    private BigDecimal productPrice;

    @NotNull(message = "Quantity Stock is required.")
    @Min(value = 0, message = "Quantity of the stock must have equal or greater than zero.")
    private Integer quantityStock;

    @NotNull(message = "Id Category is required.")
    private Long idCategory;
}
