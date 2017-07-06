package com.immoc.dao;

import com.immoc.entity.Student;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author yugi
 * @apiNote
 * @since 2017-07-06
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/spring-dao.xml"})
@Log4j2
public class StudentDaoTest {

    @Resource
    private StudentDao studentDao;

    @Test
    public void addStudentTest() throws Exception {
        Student student = new Student();
        student.setName("呵呵");
        int result = studentDao.addStudent(student);
        log.info("更新结果:{}", result);
    }

    @Test
    public void findAllStudentTest() throws Exception {
        List<Student> allStudent = studentDao.findAllStudent();
        log.info(allStudent);
    }

}