package com.grzegorznowakowski.AionDB.db.resource;

import com.grzegorznowakowski.AionDB.db.entity.TranslationEntity;
import com.grzegorznowakowski.AionDB.db.repository.TranslationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractMessageSource;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;

/**
 * @author Grzegorz Nowakowski
 */
@Component("messageSource")
public class DBMessageSource extends AbstractMessageSource {

    @Autowired
    private TranslationRepository translationRepository;


    @Override
    protected MessageFormat resolveCode(String name, Locale locale) {
        TranslationEntity message = translationRepository.findByName(name);
        String code = locale.getLanguage();
        String loca;

        //if key was not found in the database (improssibruuuu~!!11), return the key
        //possibru if DB is changed.

        if (name.equalsIgnoreCase("loca_string")) {
            return new MessageFormat(code, locale);
        } else if (name.equalsIgnoreCase("server_id")) {

            ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

            HttpServletRequest request;

            if (attr != null) {
                request = attr.getRequest();
            } else {
                return new MessageFormat("0", locale);
            }

            String parameter = request.getParameter("server");
            Cookie[] cookies = request.getCookies();

            if (parameter != null) {
                return new MessageFormat(parameter, locale);
            }

            if (cookies != null) {
                String value = Arrays.stream(cookies)
                        .filter(c -> c.getName().equals("AionPB.server"))
                        .findFirst()
                        .map(Cookie::getValue)
                        .orElse("0");
                return new MessageFormat(value, locale);
            }


        }

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
