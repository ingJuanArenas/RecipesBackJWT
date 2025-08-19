package com.recipes.recipes_backend.controller;


import com.recipes.recipes_backend.model.request.RecipeRequest;
import com.recipes.recipes_backend.model.response.RecipeResponse;
import com.recipes.recipes_backend.service.impl.RecipeServiceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/recipes")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class RecipeController {

    private final RecipeServiceImpl rs;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping()
    public List<RecipeResponse> getAllDishes() {
        return rs.getAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public RecipeResponse getRecipeById(@PathVariable Long id) {
        return rs.getById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public RecipeResponse createRecipe(@RequestBody RecipeRequest request) {
        return rs.create(request);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public RecipeResponse updateRecipe(@PathVariable Long id, @RequestBody RecipeRequest request) {
        return rs.update(id, request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteRecipe(@PathVariable Long id) {
        rs.delete(id);
    }
}
