package com.immoc.dao;

import com.immoc.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yugi
 * @apiNote
 * @since 2017-07-06
 */
@Repository
public interface StudentDao {

    int addStudent(Student student);

    List<Student> findAllStudent();
}
