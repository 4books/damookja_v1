package fourbooks.damookja.domain.controller;

import fourbooks.damookja.domain.Item;
import fourbooks.damookja.domain.service.ItemService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ItemControllerTest {

    @Autowired
    private ItemController itemController;

    @Autowired
    private ItemService itemService;

    @Test
    @Transactional
    void Item을_등록하면_해당_Item의_조회_및_동일해야함() {
        // Given
        Item item = Item.builder()
                .name("Test Item")
                .stockCount(10)
                .price(BigDecimal.valueOf(99.99))
                .createdAt(LocalDateTime.now())
                .build();

        Item savedItem = itemService.save(item);
        Long id = savedItem.getId();

        // When
        ResponseEntity<Item> response = itemController.getItemById(id);

        // Then
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(savedItem, response.getBody());
    }
}