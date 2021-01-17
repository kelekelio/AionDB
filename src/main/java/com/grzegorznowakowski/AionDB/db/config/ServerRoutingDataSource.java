package com.grzegorznowakowski.AionDB.db.config;

import com.grzegorznowakowski.AionDB.db.object.Settings;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @author Grzegorz Nowakowski
 */
public class ServerRoutingDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {

        return Settings.getServerId();

    }

}
