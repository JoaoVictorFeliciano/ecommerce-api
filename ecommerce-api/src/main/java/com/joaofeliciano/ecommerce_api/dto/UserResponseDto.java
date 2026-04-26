package com.joaofeliciano.ecommerce_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UserResponseDto {
    private Long idUser;
    private String name;
    private String email;
    private String typeUser;
    private LocalDateTime creationDate;
}
