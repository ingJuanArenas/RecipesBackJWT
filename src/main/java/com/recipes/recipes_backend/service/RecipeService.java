package com.recipes.recipes_backend.service;

import java.util.List;

import com.recipes.recipes_backend.model.request.RecipeRequest;
import com.recipes.recipes_backend.model.response.RecipeResponse;

public interface RecipeService {
    List<RecipeResponse> getAll();
    RecipeResponse getById(Long id);
    RecipeResponse create(RecipeRequest request);
    RecipeResponse update(Long id, RecipeRequest request);
    void delete(Long id);
}
