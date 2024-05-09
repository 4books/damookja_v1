package fourbooks.damookja.application.service;

import fourbooks.damookja.domain.Recipe;

import java.util.List;

public interface RecipeService {
    Recipe save(Recipe saveItem);
    List<Recipe> findAll();
    Recipe findRecipeById(Long id);
    List<Recipe> findByNameContaining(String name);
    Recipe updateRecipe(Long id, Recipe updatedItem);
    Long deleteRecipe(Long id);
}
