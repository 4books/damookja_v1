package fourbooks.damookja.DataInitializer;

import fourbooks.damookja.domain.Recipe;
import fourbooks.damookja.infrastructure.persistence.RecipeRepository;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.*;

@Component
@Slf4j
public class ItemInitializer {

    private final RecipeRepository recipeRepository;

    @Autowired
    public ItemInitializer(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @PostConstruct
    public void initialize() {
        List<Recipe> recipes = new ArrayList<>();

        recipes.add(createRecipe("1번", 10L, 100));
        recipes.add(createRecipe("2번", 20L, 200));
        recipes.add(createRecipe("3번", 30L, 300));

        recipeRepository.saveAll(recipes);
    }

    private Recipe createRecipe(String name, long price, int stockCount) {
        return Recipe.builder()
                .name(name)
                .price(price)
                .stockCount(stockCount)
                .createdAt(LocalDateTime.now())
                .build();
    }
}
