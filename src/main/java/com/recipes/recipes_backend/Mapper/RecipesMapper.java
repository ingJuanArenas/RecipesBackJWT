package com.recipes.recipes_backend.Mapper;

import com.recipes.recipes_backend.model.Recipe;
import com.recipes.recipes_backend.model.request.RecipeRequest;
import com.recipes.recipes_backend.model.response.RecipeResponse;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface RecipesMapper {

    RecipesMapper INSTANCE = Mappers.getMapper(RecipesMapper.class);

    @Mapping(target = "id", ignore = true)
    Recipe toEntity(RecipeRequest request);

    RecipeResponse toResponse(Recipe recipe);

    @Mapping(target = "id", ignore = true)
    void updateEntityFromRequest(@MappingTarget Recipe entity, RecipeRequest request);
}