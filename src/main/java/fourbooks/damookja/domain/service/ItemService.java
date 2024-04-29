package fourbooks.damookja.domain.service;

import fourbooks.damookja.domain.Item;
import fourbooks.damookja.domain.repoitory.ItemRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Item save(Item saveItem) {
        Item item = Item.builder()
                .name(saveItem.getName())
                .price(saveItem.getPrice())
                .stockCount(saveItem.getStockCount())
                .createdAt(saveItem.getCreatedAt())
                .build();

        return itemRepository.save(item);
    }

    @Transactional(readOnly = true)
    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Item findById(Long id) {
        return itemRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Item not found: " + id));
    }

    @Transactional(readOnly = true)
    public List<Item> findByNameContaining(String name) {
        return itemRepository.findByNameContaining(name);
    }

    public Item updateItem(Long id, Item updatedItem) {
        Item findItem = findById(id);

        Item newItem = Item.builder()
                .id(findItem.getId())
                .name(updatedItem.getName())
                .stockCount(updatedItem.getStockCount())
                .price(updatedItem.getPrice())
                .createdAt(updatedItem.getCreatedAt())
                .build();

        return itemRepository.save(newItem);
    }

    public Long deleteItem(Long id) {
        Item findItem = findById(id);
        itemRepository.delete(findItem);
        return findItem.getId();
    }
}
