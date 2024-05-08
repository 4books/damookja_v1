package fourbooks.damookja.application.service;

import fourbooks.damookja.domain.Recipe;
import fourbooks.damookja.application.exception.RecipeNotFoundException;
import fourbooks.damookja.infrastructure.persistence.RecipeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Transactional(readOnly = true)
@Service
public class RecipeService {

    private final RecipeRepository itemRepository;

    public RecipeService(RecipeRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Transactional
    public Recipe save(Recipe saveItem) {
        Recipe recipe = Recipe.builder()
                .name(saveItem.getName())
                .price(saveItem.getPrice())
                .stockCount(saveItem.getStockCount())
                .createdAt(saveItem.getCreatedAt())
                .build();

        return itemRepository.save(recipe);
    }

    public List<Recipe> findAll() {
        return itemRepository.findAll();
    }

    public Recipe findById(Long id) {
        return itemRepository.findById(id)
                .orElseThrow(() -> new RecipeNotFoundException("Item not found: " + id));
    }

    public List<Recipe> findByNameContaining(String name) {
        return itemRepository.findByNameContaining(name);
    }

    @Transactional
    public Recipe updateRecipe(Long id, Recipe updatedItem) {
        Recipe findRecipe = findById(id);

        Recipe newItem = Recipe.builder()
                .id(findRecipe.getId())
                .name(updatedItem.getName())
                .stockCount(updatedItem.getStockCount())
                .price(updatedItem.getPrice())
                .createdAt(updatedItem.getCreatedAt())
                .build();

        return itemRepository.save(newItem);
    }

    @Transactional
    public Long deleteItem(Long id) {
        Recipe findItem = findById(id);
        itemRepository.delete(findItem);
        return findItem.getId();
    }
}
