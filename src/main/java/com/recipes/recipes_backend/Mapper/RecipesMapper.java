package com.recipes.recipes_backend.Mapper;

import com.recipes.recipes_backend.model.Recipe;
import com.recipes.recipes_backend.model.request.RecipeRequest;
import com.recipes.recipes_backend.model.response.RecipeResponse;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface RecipesMapper {

    RecipesMapper INSTANCE = Mappers.getMapper(RecipesMapper.class);

    Recipe toEntity(RecipeRequest request);
    RecipeResponse toResponse(Recipe recipe);
}