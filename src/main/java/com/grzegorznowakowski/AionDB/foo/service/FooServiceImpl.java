package com.grzegorznowakowski.AionDB.foo.service;

import com.grzegorznowakowski.AionDB.foo.entity.Foo;
import com.grzegorznowakowski.AionDB.foo.repository.IFooRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Grzegorz Nowakowski
 */
@Service
public class FooServiceImpl implements IFooService {

    private IFooRepository fooRepository;

    public FooServiceImpl(IFooRepository fooRepository) {
        this.fooRepository = fooRepository;
    }

    @Override
    public Optional<Foo> findById(Long id) {
        return fooRepository.findById(id);
    }

    @Override
    public Foo save(Foo foo) {
        return fooRepository.save(foo);
    }

    @Override
    public Iterable<Foo> findAll() {
        return fooRepository.findAll();
    }
}
