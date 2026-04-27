package com.joaofeliciano.ecommerce_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class OrderResponseDto {
    private Long idOrder;
    private Long idUser;
    private LocalDateTime dateOrder;
    private String status;
    private String deliveryAddress;
    private BigDecimal totalValue;
}
