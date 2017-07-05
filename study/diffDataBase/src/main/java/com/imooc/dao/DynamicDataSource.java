package com.imooc.dao;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author yugi
 * @apiNote
 * @since 2017-07-05
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return CustomerContextHolder.getCustomerType();
    }
}