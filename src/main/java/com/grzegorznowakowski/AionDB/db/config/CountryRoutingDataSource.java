package com.grzegorznowakowski.AionDB.db.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @author Grzegorz Nowakowski
 */
public class CountryRoutingDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        ServletRequestAttributes attr =
                (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();


        //TODO: add server selection based on "server" cookie value
        //TODO: add server to cookie based on url param
        return "1";
    }

}
