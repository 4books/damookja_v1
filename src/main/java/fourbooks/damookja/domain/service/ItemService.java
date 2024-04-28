package fourbooks.damookja.domain.service;

import fourbooks.damookja.domain.Item;
import fourbooks.damookja.domain.repoitory.ItemRepository;
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

    public Item save(String name) {
        Item item = Item.builder()
                .name(name)
                .build();
        return itemRepository.save(item);
    }

    @Transactional(readOnly = true)
    public Optional<Item> findById(Long id) {
        return itemRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public List<Item> findByNameContaining(String name) {
        return itemRepository.findByNameContaining(name);
    }


}
