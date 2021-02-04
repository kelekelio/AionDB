package com.grzegorznowakowski.AionDB.recipe.repository;

import com.grzegorznowakowski.AionDB.recipe.entity.RecipeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Grzegorz Nowakowski
 */
@Repository
public interface RecipeRepository extends JpaRepository<RecipeEntity, Integer>, JpaSpecificationExecutor {
    Optional<RecipeEntity> findByName(String name);
}
