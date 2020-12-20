package com.grzegorznowakowski.AionDB.db.repository;

import com.grzegorznowakowski.AionDB.db.entity.TranslationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author Grzegorz Nowakowski
 */
@Repository
public interface  TranslationRepository extends JpaRepository<TranslationEntity, Integer> {

    TranslationEntity findByName (String name);

}
