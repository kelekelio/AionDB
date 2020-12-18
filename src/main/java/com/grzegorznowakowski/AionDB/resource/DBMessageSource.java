package com.grzegorznowakowski.AionDB.resource;

import com.grzegorznowakowski.AionDB.entity.TranslationEntity;
import com.grzegorznowakowski.AionDB.repository.TranslationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractMessageSource;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;
import java.util.Locale;

/**
 * @author Grzegorz Nowakowski
 */
@Component("messageSource")
public class DBMessageSource extends AbstractMessageSource {

    @Autowired
    private TranslationRepository translationRepository;

    private static final String DEFAULT_LOCALE_CODE = "body";


    @Override
    protected MessageFormat resolveCode(String name, Locale locale) {
        TranslationEntity message = translationRepository.findByName(name);
        String code = locale.getLanguage();
        String loca = "";

        if (message == null) {
            return new MessageFormat(name, locale);
        }

        switch (code) {
            case "en":
                loca = (message.getEn() != null) ? message.getEn() : message.getBody();
                break;
            case "fr":
                loca = (message.getFr() != null) ? message.getFr() : message.getBody();
                break;
            case "de":
                loca = (message.getDe() != null) ? message.getDe() : message.getBody();
                break;
            default:
                loca = message.getBody();
                break;
        }

        return new MessageFormat(loca, locale);
    }
}
