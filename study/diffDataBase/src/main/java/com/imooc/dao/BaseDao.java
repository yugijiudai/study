package com.imooc.dao;

import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @author yugi
 * @apiNote
 * @since 2017-07-05
 */
@Repository
public class BaseDao {

    @Resource
    private BaseDao1 baseDao1;

    @Resource
    private BaseDao2 baseDao2;

    public HibernateDaoSupport getDao(String name) {
        return "1".equals(name) ? baseDao1 : baseDao2;
    }

}
