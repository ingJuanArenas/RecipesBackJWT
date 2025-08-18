package com.recipes.recipes_backend.model.response;
import lombok.Data;

@Data
public class RecipeResponse {
    private Long id;
    private String name;
    private String description;
    private String instructions;
    private String src;
    private Double time;
}
