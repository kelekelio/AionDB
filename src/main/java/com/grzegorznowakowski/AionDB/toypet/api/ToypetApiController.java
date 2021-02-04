package com.grzegorznowakowski.AionDB.toypet.api;

import com.grzegorznowakowski.AionDB.toypet.entity.ToypetItemEntity;
import com.grzegorznowakowski.AionDB.toypet.entity.ToypetLootingEntity;
import com.grzegorznowakowski.AionDB.toypet.entity.ToypetMerchantEntity;
import com.grzegorznowakowski.AionDB.toypet.entity.ToypetWarehouseEntity;
import com.grzegorznowakowski.AionDB.toypet.repository.ToypetItemRepository;
import com.grzegorznowakowski.AionDB.toypet.repository.ToypetLootingRepository;
import com.grzegorznowakowski.AionDB.toypet.repository.ToypetMerchantRepository;
import com.grzegorznowakowski.AionDB.toypet.repository.ToypetWarehouseRepository;
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
public class ToypetApiController {

    @Autowired
    ToypetWarehouseRepository warehouseRepository;
    @Autowired
    ToypetMerchantRepository merchantRepository;
    @Autowired
    ToypetLootingRepository lootingRepository;
    @Autowired
    ToypetItemRepository toypetItemRepository;

    @GetMapping("/api/toypet/warehouse/{name}")
    public ResponseEntity<ToypetWarehouseEntity> getToypetWarehouseByName(@PathVariable("name") String name) {
        Optional<ToypetWarehouseEntity> entity = warehouseRepository.findByName(name);
        return entity.map(WarehouseEntity -> new ResponseEntity<>(WarehouseEntity, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/api/toypet/merchant/{name}")
    public ResponseEntity<ToypetMerchantEntity> getToypetMerchantByName(@PathVariable("name") String name) {
        Optional<ToypetMerchantEntity> entity = merchantRepository.findByName(name);
        return entity.map(MerchantEntity -> new ResponseEntity<>(MerchantEntity, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/api/toypet/looting/{name}")
    public ResponseEntity<ToypetLootingEntity> getToypetLootingByName(@PathVariable("name") String name) {
        Optional<ToypetLootingEntity> entity = lootingRepository.findByName(name);
        return entity.map(LootingEntity -> new ResponseEntity<>(LootingEntity, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/api/toypet/item/{name}")
    public ResponseEntity<ToypetItemEntity> getToypetItemByName(@PathVariable("name") String name) {
        Optional<ToypetItemEntity> entity = toypetItemRepository.findByName(name);
        return entity.map(ItemEntity -> new ResponseEntity<>(ItemEntity, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }




}
