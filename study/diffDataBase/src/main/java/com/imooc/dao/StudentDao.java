package com.imooc.dao;

import com.imooc.pojo.Student;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author yugi
 * @apiNote
 * @since 2017-06-27
 */
@Repository
public class StudentDao {

    @Resource
    private BaseDao baseDao;


    @Transactional
    public void addStudent(Student student) {
        baseDao.getHibernateTemplate().saveOrUpdate(student);
    }

    public Student findStudent(Long id) {
        return baseDao.getHibernateTemplate().get(Student.class, id);
    }
}
