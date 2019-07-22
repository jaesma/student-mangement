package com.manalangjames.application.service;

import com.manalangjames.application.entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> findAll();

    Student findById(Integer id);

    void deleteById(Integer id);

    void save(Student student);
}
