package com.grzegorznowakowski.AionDB.db.service;

import com.grzegorznowakowski.AionDB.db.entity.TranslationEntity;
import com.grzegorznowakowski.AionDB.db.repository.TranslationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Grzegorz Nowakowski
 */
@Service
public class TranslationService {

    @Autowired
    private TranslationRepository translationRepository;

    public TranslationEntity findByName(String name) {

        TranslationEntity translationEntity = translationRepository.findByName(name);

        if (translationEntity == null) {
            //getting rid of npe
            translationEntity = new TranslationEntity();
        }

        return translationEntity;
    }
}
