package com.joaofeliciano.ecommerce_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CategoryResponseDto {
    private Long idCategory;
    private String name;
    private String description;
}
