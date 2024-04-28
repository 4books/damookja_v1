package fourbooks.damookja.domain.repoitory;

import fourbooks.damookja.domain.Items;
import fourbooks.damookja.domain.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/items/{id}")
    public ResponseEntity<Items> getItemById(@PathVariable("id") Long id) {
        Items item = itemService.findById(id);
        if (item != null) {
            return ResponseEntity.ok(item);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/items")
    public ResponseEntity<?> createItem(@RequestBody Items item) {
        try {
            Items savedItem = itemService.save(item.getName());
            return ResponseEntity.ok(savedItem);
        } catch (Exception e) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("message", "Failed to save item");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }
}
