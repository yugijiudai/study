package com.imooc.dao;

import com.imooc.pojo.Student;
import lombok.extern.log4j.Log4j2;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author yugi
 * @apiNote
 * @since 2017-06-27
 */
@Repository
@Log4j2
public class StudentDao {


    @Resource
    private BaseDaoFactory baseDaoFactory;


    /**
     * 如果有多个数据源这里的事务要指定对应哪个,如果用了@Transactional,即使用了CustomerContextHolder.setCustomerType("2")也会无效,他们的数据源还是不会变,
     * 如果想一次保存到多个数据源,从第二个数据源开始必须手动开启事务,并且用openSession拿到新的session,不然用currentSession的话还是会是之前数据源
     */
    @Transactional
    public void addStudent(Student student1, Student student2) {
        // HibernateDaoSupport dao = baseDao.getDao();
        Transaction tx1 = null;
        Session session = null;
        try {
            BaseDao baseDao = baseDaoFactory.getDao();
            baseDao.getHibernateTemplate().saveOrUpdate(student1);
            baseDao = baseDaoFactory.getDao("2");
            // CustomerContextHolder.setCustomerType("2");
            session = baseDao.getHibernateTemplate().getSessionFactory().openSession();
            tx1 = session.beginTransaction();
            // baseDao.getHibernateTemplate().saveOrUpdate(student1);
            session.saveOrUpdate(student2);
            // baseDao.getSessionFactory().openSession().saveOrUpdate(student1);
            // Integer.parseInt("few");
            tx1.commit();
        }
        catch (Exception e) {
            if (tx1 != null) {
                tx1.rollback();
                log.fatal("回滚");
            }
            throw new RuntimeException(e);
        }
        finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public Student findStudent(Long id) {
        return baseDaoFactory.getDao().getHibernateTemplate().get(Student.class, id);
    }

    public Student findStudentFactory1(Long id) {
        BaseDao baseDao = baseDaoFactory.getDao();
        return baseDao.getHibernateTemplate().get(Student.class, id);
    }

    public Student findStudentFactory2(Long id) {
        BaseDao baseDao = baseDaoFactory.getDao("2");
        return baseDao.getHibernateTemplate().get(Student.class, id);
    }

    public Student findStudentFactory3(Long id) {
        BaseDao baseDao = baseDaoFactory.getDao();
        Student student = baseDao.getHibernateTemplate().get(Student.class, id);
        log.info(student);
        baseDao = baseDaoFactory.getDao("2");
        return baseDao.getHibernateTemplate().get(Student.class, id);
    }

}
