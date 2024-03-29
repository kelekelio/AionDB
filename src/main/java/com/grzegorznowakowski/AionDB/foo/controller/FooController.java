package com.grzegorznowakowski.AionDB.foo.controller;

import com.grzegorznowakowski.AionDB.foo.entity.Foo;
import com.grzegorznowakowski.AionDB.foo.entity.FooDto;
import com.grzegorznowakowski.AionDB.foo.service.IFooService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Grzegorz Nowakowski
 */
@RestController
@RequestMapping(value = "/api/foos")
public class FooController {

    private IFooService fooService;

    public FooController(IFooService fooService) {
        this.fooService = fooService;
    }

    @CrossOrigin(origins = "http://localhost:8089")
    @GetMapping(value = "/{id}")
    public FooDto findOne(@PathVariable Long id) {
        Foo entity = fooService.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return convertToDto(entity);
    }

    @GetMapping
    public Collection<FooDto> findAll() {
        Iterable<Foo> foos = this.fooService.findAll();
        List<FooDto> fooDtos = new ArrayList<>();
        foos.forEach(p -> fooDtos.add(convertToDto(p)));
        return fooDtos;
    }

    protected FooDto convertToDto(Foo entity) {
        FooDto dto = new FooDto(entity.getId(), entity.getName());

        return dto;
    }
}
