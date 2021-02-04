package com.grzegorznowakowski.AionDB.toypet.api;

import com.grzegorznowakowski.AionDB.assemble.entity.AssembleEntity;
import com.grzegorznowakowski.AionDB.toypet.entity.MerchantEntity;
import com.grzegorznowakowski.AionDB.toypet.entity.WarehouseEntity;
import com.grzegorznowakowski.AionDB.toypet.repository.MerchantRepository;
import com.grzegorznowakowski.AionDB.toypet.repository.WarehouseRepository;
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
    WarehouseRepository warehouseRepository;
    @Autowired
    MerchantRepository merchantRepository;

    @GetMapping("/api/toypet/warehouse/{name}")
    public ResponseEntity<WarehouseEntity> getToypetWarehouseByName(@PathVariable("name") String name) {

        Optional<WarehouseEntity> warehouseEntity = warehouseRepository.findByName(name);

        return warehouseEntity.map(WarehouseEntity -> new ResponseEntity<>(WarehouseEntity, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    @GetMapping("/api/toypet/merchant/{name}")
    public ResponseEntity<MerchantEntity> getToypetMerchantByName(@PathVariable("name") String name) {
        Optional<MerchantEntity> merchantEntity = merchantRepository.findByName(name);
        return merchantEntity.map(MerchantEntity -> new ResponseEntity<>(MerchantEntity, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }




}
