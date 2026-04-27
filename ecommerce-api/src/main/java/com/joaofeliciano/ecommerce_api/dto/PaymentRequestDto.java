package com.joaofeliciano.ecommerce_api.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PaymentRequestDto {

    @NotNull(message = "Id Order is required.")
    private Long idOrder;

    @NotBlank(message = "Payment Method is required.")
    private String paymentMethod;

    @NotNull(message = "Payment Value is required.")
    @DecimalMin(value = "0.0", inclusive = false, message = "Payment value must have be greater than zero.")
    private BigDecimal paymentValue;
}
