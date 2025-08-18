package com.recipes.recipes_backend.model.request;

import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Data
public class RecipeRequest {
    @NotBlank
    private String name;

    @NotBlank
    private String description;

    @NotBlank
    private String instructions;

    @NotBlank
    private String src;

    @NotNull
    @Positive
    private Double time;
}
