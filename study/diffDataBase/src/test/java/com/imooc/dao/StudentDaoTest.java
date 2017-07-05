package com.imooc.dao;

import com.imooc.pojo.Student;
import lombok.extern.log4j.Log4j2;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @author zhonghaowen
 * @apiNote
 * @since 2017-07-04
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-hibernate.xml"})
@Log4j2
public class StudentDaoTest {

    @Resource
    private StudentDao studentDao;

    @Test
    public void addStudent() throws Exception {
        Assert.assertNotNull(studentDao);
        Student student1 = new Student();
        student1.setSname("嘿嘿1");
        Student student2 = new Student();
        student2.setSname("嘿嘿2");
        studentDao.addStudent(student1, student2);
    }

    @Test
    public void findStudent() throws Exception {
        Student student = studentDao.findStudent(1L);
        log.info(student);
    }

    @Test
    public void findStudentFactory() throws Exception {
        Student student1 = studentDao.findStudentFactory1(1L);
        log.info(student1);
        Student student2 = studentDao.findStudentFactory2(1L);
        log.info(student2);
    }

    @Test
    public void findStudentFactory3() throws Exception {
        Student student1 = studentDao.findStudentFactory3(1L);
        log.info(student1);
    }


}