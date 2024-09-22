package com.app.springbootpractice.service.impl;

import com.app.springbootpractice.model.Student;
import com.app.springbootpractice.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class StudentService1Impl implements StudentService {
    @Override
    public List<Student> findAll() {
        return null;
    }

    @Override
    public Student save(Student user) {
        return null;
    }

    @Override
    public Student update(Student id) {
        return null;
    }

    @Override
    public void delete(Integer integer) {

    }

    @Override
    public Student findById(Integer integer) {
        return null;
    }

    @Override
    public String testBean() {
        return "StudentService1IMPL";
    }
}
