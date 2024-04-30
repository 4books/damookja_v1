package fourbooks.damookja.domain.exhandler.advice;

import fourbooks.damookja.domain.controller.ItemController;
import fourbooks.damookja.domain.service.ItemService;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@SpringBootTest
class ExControllerAdviceTest {

    @InjectMocks
    private ItemController itemController;

    @Mock
    private ItemService itemService;

    @Test
    void Item이_없으면_EntityNotFoundException_발생해야함() {
        // Given
        Long id = Long.MAX_VALUE;
        String errorMessage = "Item not found with id: " + id;
        when(itemService.findById(id)).thenThrow(new EntityNotFoundException(errorMessage));

        // When & Then
        assertThrows(EntityNotFoundException.class, () -> itemController.getItemById(id));
    }
}