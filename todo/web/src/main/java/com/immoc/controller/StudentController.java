package com.immoc.controller;

import com.immoc.dao.StudentDao;
import com.immoc.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author yugi
 * @apiNote
 * @since 2017-07-06
 */
@RestController
public class StudentController {


    @Resource
    private StudentDao studentDao;

    @GetMapping(value = "/getAllStudent")
    public List<Student> getAllStudent() {
        return studentDao.findAllStudent();
    }

    @PostMapping(value = "/getAllStudent2")
    public Student get(@RequestBody Student student) {
        return student;
    }

}
