package com.grzegorznowakowski.AionDB.api.controller;

import com.grzegorznowakowski.AionDB.items.entity.ItemEntity;
import com.grzegorznowakowski.AionDB.items.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @author Grzegorz Nowakowski
 */
@RestController
public class ItemApiController {

    @Autowired
    private ItemRepository itemRepository;


    @GetMapping("/api/item/{id}")
    public ResponseEntity<ItemEntity> getItemById(@PathVariable("id") Integer id) {
        Optional<ItemEntity> item = itemRepository.findById(id);

        return item.map(itemEntity -> new ResponseEntity<>(itemEntity, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }
}
