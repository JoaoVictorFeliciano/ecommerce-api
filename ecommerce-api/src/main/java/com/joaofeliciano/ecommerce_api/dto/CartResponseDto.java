package com.joaofeliciano.ecommerce_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CartResponseDto {
    private Long idCart;
    private Long idUser;
    private LocalDateTime creationDateCart;
}
