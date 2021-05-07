package com.grzegorznowakowski.AionDB.foo.service;

import com.grzegorznowakowski.AionDB.foo.entity.Foo;

import java.util.Optional;

/**
 * @author Grzegorz Nowakowski
 */
public interface IFooService {
    Optional<Foo> findById(Long id);

    Foo save(Foo foo);

    Iterable<Foo> findAll();

}