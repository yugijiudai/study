package com.imooc.dao;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @author yugi
 * @apiNote
 * @since 2017-07-05
 */
@Repository
public class BaseDao2 extends HibernateDaoSupport {

    @Resource(name = "sessionFactory2")
    public void setSuperSessionFactory(SessionFactory sessionFactory){
        super.setSessionFactory(sessionFactory);
    }
}
