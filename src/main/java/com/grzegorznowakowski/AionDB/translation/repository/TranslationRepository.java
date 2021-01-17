package com.grzegorznowakowski.AionDB.translation.repository;

import com.grzegorznowakowski.AionDB.translation.entity.TranslationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Grzegorz Nowakowski
 */
@Repository
public interface  TranslationRepository extends JpaRepository<TranslationEntity, Integer> {

    TranslationEntity findByName (String name);

}
