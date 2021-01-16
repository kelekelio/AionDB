package com.grzegorznowakowski.AionDB.db.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @author Grzegorz Nowakowski
 */
public class CountryRoutingDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        if (attr != null) {
            HttpServletRequest request = attr.getRequest();

            return Arrays.stream(request.getCookies())
                    .filter(c -> c.getName().equals("AionPB.server"))
                    .findFirst()
                    .map(Cookie::getValue)
                    .orElse("0");
        }

        return "0";

    }

}
