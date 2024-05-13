package fourbooks.damookja.application.port.in.api.controller;

import fourbooks.damookja.application.service.RecipeService;
import fourbooks.damookja.domain.Recipe;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
@RequiredArgsConstructor
public class RecipeController {

    private final RecipeService recipeService;

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

    //TODO Entity 노출되지 않게 DTO로 변경
    @PostMapping
    public ResponseEntity<Recipe> createItem(@Valid @RequestBody Recipe saveRecipeParam) {
        return new ResponseEntity<>(recipeService.save(saveRecipeParam), HttpStatus.CREATED);
    }

    //TODO Entity 노출되지 않게 DTO로 변경
    @PutMapping("/{id}")
    public ResponseEntity<Recipe> updateItem(@PathVariable("id") Long id, @RequestBody Recipe updateRecipeParam) {
        return new ResponseEntity<>(recipeService.updateRecipe(id, updateRecipeParam), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteItem(@PathVariable("id") Long id) {
        return new ResponseEntity<>(recipeService.deleteRecipe(id), HttpStatus.OK);
    }
}
