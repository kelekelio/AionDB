package com.grzegorznowakowski.AionDB.dungeon.api;

import com.grzegorznowakowski.AionDB.dungeon.entity.DungeonEntity;
import com.grzegorznowakowski.AionDB.dungeon.repository.DungeonsDataTablesRepository;
import com.grzegorznowakowski.AionDB.dungeon.service.DungeonsDataTablesService;
import com.grzegorznowakowski.AionDB.items.entity.ItemEntity;
import com.grzegorznowakowski.AionDB.items.object.ItemIdRangeObj;
import com.grzegorznowakowski.AionDB.items.repository.ItemDataTablesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author Grzegorz Nowakowski
 */
@RestController
public class DungeonsDataTablesController {

    @Autowired
    private DungeonsDataTablesRepository dungeonsDataTablesRepository;

    @Autowired
    private DungeonsDataTablesService dungeonsDataTablesService;


    @RequestMapping(value = {"/dungeonsajax"}, method = RequestMethod.GET)
    public DataTablesOutput<DungeonEntity> listDataTablesForDungeonsGET(@Valid DataTablesInput input) {

        return dungeonsDataTablesService.findAll(input);
    }

    @RequestMapping(value = "/dungeonsajax", method = RequestMethod.POST)
    public DataTablesOutput<DungeonEntity> listDataTablesForDungeonsPOST(@Valid @RequestBody DataTablesInput input) {
        return dungeonsDataTablesService.findAll(input);
    }













}
