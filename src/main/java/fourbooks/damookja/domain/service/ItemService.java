package fourbooks.damookja.domain.service;

import fourbooks.damookja.domain.Items;
import fourbooks.damookja.domain.repoitory.ItemRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;

@Transactional
@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Items save(String name) {
        Items items = new Items(name);
        return itemRepository.save(items);
    }

    @Transactional(readOnly = true)
    public Items findById(Long id) {
        Optional<Items> byId = itemRepository.findById(id);
        return byId.orElse(null);
    }

    public Items findByName(String name) {
        return null;
    }


}
