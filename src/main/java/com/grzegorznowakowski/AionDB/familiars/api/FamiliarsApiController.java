package com.grzegorznowakowski.AionDB.familiars.api;

import com.grzegorznowakowski.AionDB.assemble.entity.AssembleEntity;
import com.grzegorznowakowski.AionDB.familiars.entity.FamiliarEntity;
import com.grzegorznowakowski.AionDB.familiars.repository.FamiliarRepository;
import com.grzegorznowakowski.AionDB.items.api.ItemApiController;
import com.grzegorznowakowski.AionDB.recipe.entity.RecipeEntity;
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
public class FamiliarsApiController {


    @Autowired
    FamiliarRepository familiarRepository;

    @GetMapping("/api/familiar/{id}")
    public ResponseEntity<FamiliarEntity> getFamiliarById(@PathVariable("id") Integer id) {

        Optional<FamiliarEntity> familiarEntity = familiarRepository.findById(id);

        return familiarEntity.map(FamiliarEntity -> new ResponseEntity<>(FamiliarEntity, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    @GetMapping("/api/familiar/{column}/{value}")
    public List<FamiliarEntity> getFamiliarsByColumnAndValue(@PathVariable("column") String column, @PathVariable("value") String value) {

        return familiarRepository.findAll(ItemApiController.byColumnNameAndValue(column, value));


    }
}
