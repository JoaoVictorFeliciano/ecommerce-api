package com.joaofeliciano.ecommerce_api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class TelephoneRequestDto {

    @NotBlank(message = "Number Phone is required.")
    @Pattern(regexp = "\\d{10,11}",  message = "Invalid Phone Number")
    private String numberPhone;
}
