package com.imooc.dao;

import lombok.extern.log4j.Log4j2;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.SQLException;

/**
 * @author yugi
 * @apiNote
 * @since 2017-07-06
 */
@Repository
@Log4j2
public class BaseDaoFactory {


    @Resource
    private BaseDao baseDao;


    public BaseDao getDao() {
        return getDao(null);
    }

    public BaseDao getDao(String type) {
        type = null == type ? "1" : "2";
        CustomerContextHolder.setCustomerType(type);
        this.getDataBaseUrl(baseDao);
        return baseDao;
    }

    private String getDataBaseUrl(HibernateDaoSupport dao) {
        try {
            String url = ((SessionFactoryImplementor) dao.getSessionFactory()).getConnectionProvider().getConnection().getMetaData().getURL();
            log.info("数据库url:{}", url);
            return url;
        }
        catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }


}
