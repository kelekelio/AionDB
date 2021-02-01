package com.grzegorznowakowski.AionDB.assemble.api;

import com.grzegorznowakowski.AionDB.assemble.entity.AssembleEntity;
import com.grzegorznowakowski.AionDB.assemble.entity.AssemblePartsEntity;
import com.grzegorznowakowski.AionDB.assemble.repository.AssemblePartsRepository;
import com.grzegorznowakowski.AionDB.assemble.repository.AssembleRepository;
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
public class AssembleApiController {

    @Autowired
    private AssembleRepository assembleRepository;

    @Autowired
    private AssemblePartsRepository assemblePartsRepository;


    @GetMapping("/api/assemble/{name}")
    public ResponseEntity<AssembleEntity> getAssembleByName(@PathVariable("name") String name) {

        Optional<AssembleEntity> assembleEntity = assembleRepository.findByName(name);
        //assembleEntity.ifPresent(assembleEntity1 -> assembleEntity.get().setAssembleParts(assemblePartsRepository.findAllByName(name)));

        return assembleEntity.map(AssembleEntity -> new ResponseEntity<>(AssembleEntity, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }


    @GetMapping("/api/assembleParts/{column}/{name}")
    public List<AssemblePartsEntity> getAssemblePartsByName(@PathVariable("column") String column, @PathVariable("name") String name) {

        switch (column){
            case "partItem":
                return assemblePartsRepository.findAllByPartItem(name);
            default:
                return assemblePartsRepository.findAllByName(name);
        }


    }


}
