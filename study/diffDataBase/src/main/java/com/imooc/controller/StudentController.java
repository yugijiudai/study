package com.imooc.controller;

import com.imooc.dao.StudentDao;
import com.imooc.pojo.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zhonghaowen
 * @apiNote
 * @since 2017-07-04
 */
@RestController
public class StudentController {

    @Resource
    private StudentDao studentDao;


    @GetMapping(value = "/{id}/getStudent")
    public Student getStudent(@PathVariable("id") String id) {
        return studentDao.findStudent(new Long(id));
    }


    @PostMapping(value = "addStudent")
    public Student addStudent(@RequestBody Student student) {
        studentDao.addStudent(student, student);
        return student;
    }
}
