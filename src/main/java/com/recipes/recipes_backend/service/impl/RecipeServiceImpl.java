package com.recipes.recipes_backend.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.recipes.recipes_backend.Mapper.RecipesMapper;
import com.recipes.recipes_backend.model.request.RecipeRequest;
import com.recipes.recipes_backend.model.response.RecipeResponse;
import com.recipes.recipes_backend.repository.RecipeRepository;
import com.recipes.recipes_backend.service.RecipeService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RecipeServiceImpl  implements RecipeService{
    
        private final RecipeRepository rr;
        private final RecipesMapper mapper;
        @Override
        public List<RecipeResponse> getAll() {
            return rr.findAll().stream().map(mapper::toResponse).toList();
        }

        @Override
        public RecipeResponse getById(Long id) {
            var recipe = rr.findById(id).orElseThrow(() -> new RuntimeException("Recipe not found"));
            return mapper.toResponse(recipe);
        }

        @Override
        public RecipeResponse create(RecipeRequest request) {
            var newRecipe = mapper.toEntity(request);
            rr.save(newRecipe);
            return mapper.toResponse(newRecipe);
        }

        @Override
        public RecipeResponse update(Long id, RecipeRequest request) {
            var existingRecipe = rr.findById(id).orElseThrow(() -> new RuntimeException("Recipe not found"));
            mapper.updateEntityFromRequest(existingRecipe, request);
            rr.save(existingRecipe);
            return mapper.toResponse(existingRecipe);
        }

        @Override
        public void delete(Long id) {
            var toDelete = rr.findById(id).orElseThrow(() -> new RuntimeException("Recipe not found"));
            rr.delete(toDelete);
        }

}
