package com.imooc.dao;

import com.imooc.pojo.Student;
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
public class StudentDaoTest {

    @Resource
    private StudentDao studentDao;

    @Test
    public void addStudent() throws Exception {
        Assert.assertNotNull(studentDao);
        Student student = new Student();
        student.setSname("张三");
        studentDao.addStudent(student);
    }

    @Test
    public void findStudent() throws Exception {
        Student student = studentDao.findStudent(1L);
        System.out.println(student);
    }

}