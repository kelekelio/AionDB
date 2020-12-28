package com.grzegorznowakowski.AionDB.api.controller;

import com.grzegorznowakowski.AionDB.items.entity.ItemEntity;
import com.grzegorznowakowski.AionDB.items.repository.ItemDataTablesRepository;
import com.grzegorznowakowski.AionDB.items.repository.ItemRepository;
import com.grzegorznowakowski.AionDB.items.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.Expression;
import javax.validation.Valid;
import java.util.List;

/**
 * @author Grzegorz Nowakowski
 */
@RestController
public class ItemsDataTablesController {

    @Autowired
    private ItemDataTablesRepository itemDataTablesRepository;


    @RequestMapping(value = "/itemajax", method = RequestMethod.GET)
    public DataTablesOutput<ItemEntity> list(@Valid DataTablesInput input) {

        Specification<ItemEntity> itemEntitySpecification = (Specification<ItemEntity>) (root, query, criteriaBuilder) -> {


            Expression<String> weaponTypeExpression = criteriaBuilder.lower(root.get("weaponType"));

            return criteriaBuilder.and(
                    criteriaBuilder.equal(weaponTypeExpression, "1h_dagger")
            );
        };



        return itemDataTablesRepository.findAll(input, itemEntitySpecification);
    }

    @RequestMapping(value = "/itemajax", method = RequestMethod.POST)
    public DataTablesOutput<ItemEntity> listPOST(@Valid @RequestBody DataTablesInput input) {
        return itemDataTablesRepository.findAll(input);
    }


}
