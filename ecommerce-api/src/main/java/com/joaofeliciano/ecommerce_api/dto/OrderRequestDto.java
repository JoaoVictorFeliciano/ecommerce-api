package com.joaofeliciano.ecommerce_api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class OrderRequestDto {

    @NotNull(message = "Id User is required.")
    private Long idUser;

    @NotBlank(message = "Delivery address is required.")
    private String deliveryAddress;

}
