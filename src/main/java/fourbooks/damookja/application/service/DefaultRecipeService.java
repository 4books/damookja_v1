package fourbooks.damookja.application.service;

import fourbooks.damookja.domain.Recipe;
import fourbooks.damookja.domain.exception.RecipeNotFoundException;
import fourbooks.damookja.infrastructure.persistence.RecipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
public class DefaultRecipeService implements RecipeService {

    private final RecipeRepository recipeRepository;

    @Transactional
    public Recipe save(Recipe saveItem) {
        Recipe recipe = Recipe.builder()
                .name(saveItem.getName())
                .price(saveItem.getPrice())
                .stockCount(saveItem.getStockCount())
                .createdAt(saveItem.getCreatedAt())
                .build();

        return recipeRepository.save(recipe);
    }

    public List<Recipe> findAll() {
        return recipeRepository.findAll();
    }

    public Recipe findRecipeById(Long id) {
        return recipeRepository.findById(id)
                .orElseThrow(() -> new RecipeNotFoundException("Recipe not found: " + id));
    }

    public List<Recipe> findByNameContaining(String name) {
        return recipeRepository.findByNameContaining(name);
    }

    @Transactional
    public Recipe updateRecipe(Long id, Recipe updatedItem) {
        Recipe findRecipe = findRecipeById(id);

        Recipe updateRecipe = Recipe.builder()
                .id(findRecipe.getId())
                .name(updatedItem.getName())
                .stockCount(updatedItem.getStockCount())
                .price(updatedItem.getPrice())
                .createdAt(updatedItem.getCreatedAt())
                .build();

        return recipeRepository.save(updateRecipe);
    }

    @Transactional
    public Long deleteRecipe(Long id) {
        Recipe findItem = findRecipeById(id);
        recipeRepository.delete(findItem);
        return findItem.getId();
    }
}
