package com.joaofeliciano.ecommerce_api.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CartRequestDto {

    @NotNull(message = "Id user is required.")
    private Long idUser;

}
