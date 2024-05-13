package fourbooks.damookja.recipe.exhandler.advice;

import fourbooks.damookja.application.port.in.api.controller.RecipeController;
import fourbooks.damookja.domain.exception.RecipeNotFoundException;
import fourbooks.damookja.application.service.DefaultRecipeService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@SpringBootTest
class ExceptionControllerAdviceTest {

    @InjectMocks
    private RecipeController recipeController;

    @Mock
    private DefaultRecipeService recipeService;

    @Test
    void Item이_없으면_ItemNotFoundException_발생해야함() {
        // Given
        Long id = Long.MAX_VALUE;
        String errorMessage = "Item not found with id: " + id;
        when(recipeService.findRecipeById(id)).thenThrow(new RecipeNotFoundException(errorMessage));

        // When & Then
        assertThrows(RecipeNotFoundException.class, () -> recipeController.getItemById(id));
    }
}