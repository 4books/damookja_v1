package fourbooks.damookja.application.port.in.web.controller;

import fourbooks.damookja.application.service.RecipeService;
import fourbooks.damookja.domain.Recipe;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
public class RecipeController {

    private final RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping
    public ResponseEntity<List<Recipe>> getAll() {
        return new ResponseEntity<>(recipeService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recipe> getItemById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(recipeService.findRecipeById(id), HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Recipe>> getItemByName(@PathVariable("name") String name) {
        return new ResponseEntity<>(recipeService.findByNameContaining(name), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Recipe> createItem(@Valid @RequestBody Recipe saveItem) {
        return new ResponseEntity<>(recipeService.save(saveItem), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Recipe> updateItem(@PathVariable("id") Long id, @RequestBody Recipe updateItem) {
        return new ResponseEntity<>(recipeService.updateRecipe(id, updateItem), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteItem(@PathVariable("id") Long id) {
        return new ResponseEntity<>(recipeService.deleteRecipe(id), HttpStatus.OK);
    }
}
