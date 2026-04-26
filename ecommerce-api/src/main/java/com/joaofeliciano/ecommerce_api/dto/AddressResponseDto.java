package com.joaofeliciano.ecommerce_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AddressResponseDto {
    private Long idAddress;
    private String cep;
    private String road;
    private String city;
    private String state;
    private String houseNumber;
}
