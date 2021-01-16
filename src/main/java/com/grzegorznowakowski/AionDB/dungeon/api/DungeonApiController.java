package com.grzegorznowakowski.AionDB.dungeon.api;



import com.grzegorznowakowski.AionDB.dungeon.entity.DungeonEntity;
import com.grzegorznowakowski.AionDB.dungeon.repository.DungeonRepository;
import com.nimbusds.jose.shaded.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * @author Grzegorz Nowakowski
 */
@RestController
public class DungeonApiController {

    @Autowired
    DungeonRepository dungeonRepository;

    @GetMapping("/api/dungeons")
    public List<DungeonEntity> getAllDungeons() {
        return dungeonRepository.findAll();
    }
}
