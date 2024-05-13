package fourbooks.damookja.recipe.controller;

import fourbooks.damookja.application.port.in.api.controller.RecipeController;
import fourbooks.damookja.domain.Recipe;
import fourbooks.damookja.application.service.DefaultRecipeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
class RecipeControllerTest {

    @Autowired
    private RecipeController recipeController;

    @Autowired
    private DefaultRecipeService recipeService;

    @Test
    void Item을_등록하면_해당_Item의_조회_및_동일해야함() {
        // Given
        Recipe recipe = Recipe.builder()
                .name("Test Item")
                .stockCount(10)
                .price(99L)
                .createdAt(LocalDateTime.now())
                .build();

        Recipe savedItem = recipeService.save(recipe);
        Long id = savedItem.getId();

        // When
        ResponseEntity<Recipe> response = recipeController.getItemById(id);

        // Then
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(savedItem, response.getBody());
    }
}