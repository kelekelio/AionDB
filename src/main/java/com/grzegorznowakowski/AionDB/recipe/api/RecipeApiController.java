package com.grzegorznowakowski.AionDB.recipe.api;

import com.grzegorznowakowski.AionDB.assemble.entity.AssembleEntity;
import com.grzegorznowakowski.AionDB.items.api.ItemApiController;
import com.grzegorznowakowski.AionDB.recipe.entity.RecipeEntity;
import com.grzegorznowakowski.AionDB.recipe.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * @author Grzegorz Nowakowski
 */
@RestController
public class RecipeApiController {


    @Autowired
    RecipeRepository recipeRepository;

    @GetMapping("/api/recipe/{name}")
    public ResponseEntity<RecipeEntity> getRecipeByName(@PathVariable("name") String name) {

        Optional<RecipeEntity> recipeEntity = recipeRepository.findByName(name);

        return recipeEntity.map(RecipeEntity -> new ResponseEntity<>(RecipeEntity, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    @GetMapping("/api/recipe/{column}/{value}")
    public List<RecipeEntity> getRecipeByColumnAndValue(@PathVariable("column") String column, @PathVariable("value") String value) {

        return recipeRepository.findAll(ItemApiController.byColumnNameAndValue(column, value));


    }



}
