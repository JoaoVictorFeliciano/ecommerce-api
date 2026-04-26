package com.joaofeliciano.ecommerce_api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AddressRequestDto {

    @NotBlank(message = "CEP is required.")
    @Size(min = 8, max = 9, message = "CEP must have at least 8 numbers")
    private String cep;

    @NotBlank(message =  "Road is required.")
    private String road;

    @NotBlank(message = "City is required.")
    private String city;

    @NotBlank(message = "House Number is required.")
    private String houseNumber;

    @NotBlank(message = "State is required.")
    private String state;

}
