package com.joaofeliciano.ecommerce_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class TelephoneResponseDto {
    private Long idTelephone;
    private String numberPhone;
}
