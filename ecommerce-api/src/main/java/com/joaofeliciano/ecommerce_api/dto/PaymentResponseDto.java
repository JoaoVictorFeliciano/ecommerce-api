package com.joaofeliciano.ecommerce_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PaymentResponseDto {
    private Long idPayment;
    private Long idOrder;
    private String paymentMethod;
    private BigDecimal paymentValue;
    private String paymentStatus;
    private LocalDateTime paymentDate;
}
