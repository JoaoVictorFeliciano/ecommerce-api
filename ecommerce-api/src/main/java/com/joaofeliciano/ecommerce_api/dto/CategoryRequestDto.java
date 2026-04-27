package com.joaofeliciano.ecommerce_api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CategoryRequestDto {

    @NotBlank(message = "Category name is required.")
    @Size(max = 100, message = "Category name must have at most 100 characters.")
    private String name;

    @NotBlank(message = "Description is required.")
    private String description;
}
