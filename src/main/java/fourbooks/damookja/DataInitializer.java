package fourbooks.damookja;

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
public class DataInitializer {

    private final RecipeRepository itemRepository;

    @Autowired
    public DataInitializer(RecipeRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @PostConstruct
    public void initialize() {
        List<Recipe> items = new ArrayList<>();

        items.add(createItem("1번", 10L, 100));
        items.add(createItem("2번", 20L, 200));
        items.add(createItem("3번", 30L, 300));

        itemRepository.saveAll(items);
    }

    private Recipe createItem(String name, long price, int stockCount) {
        return Recipe.builder()
                .name(name)
                .price(price)
                .stockCount(stockCount)
                .createdAt(LocalDateTime.now())
                .build();
    }
}
