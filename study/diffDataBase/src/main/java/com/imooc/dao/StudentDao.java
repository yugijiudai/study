package com.imooc.dao;

import com.alibaba.druid.pool.DruidDataSource;
import com.imooc.pojo.Student;
import lombok.extern.log4j.Log4j2;
import org.hibernate.SessionFactory;
import org.hibernate.engine.jdbc.connections.internal.DatasourceConnectionProviderImpl;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

/**
 * @author yugi
 * @apiNote
 * @since 2017-06-27
 */
@Repository
@Log4j2
public class StudentDao {

    @Resource
    private BaseDao baseDao;

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

    // 如果有多个数据源这里的事务要指定对应哪个
    @Transactional
    public void addStudent(Student student) {
        HibernateDaoSupport dao = baseDao.getDao("1");
        dao.getHibernateTemplate().saveOrUpdate(student);
    }

    public Student findStudent(Long id) {
        HibernateDaoSupport dao = baseDao.getDao("1");
        return dao.getHibernateTemplate().get(Student.class, id);
    }

    public Student findStudentFactory1(Long id) {
        HibernateDaoSupport dao = baseDao.getDao("1");
        this.getDataBaseUrl(dao);
        return dao.getHibernateTemplate().get(Student.class, id);
    }

    public Student findStudentFactory2(Long id) {
        HibernateDaoSupport dao = baseDao.getDao("2");
        this.getDataBaseUrl(dao);
        return dao.getHibernateTemplate().get(Student.class, id);

    }
}
