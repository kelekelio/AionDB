package com.grzegorznowakowski.AionDB.foo.repository;

import com.grzegorznowakowski.AionDB.foo.entity.Foo;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author Grzegorz Nowakowski
 */
public interface IFooRepository extends PagingAndSortingRepository<Foo, Long> {
}
