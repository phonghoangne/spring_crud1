package com.app.springbootpractice.service.impl;

import com.app.springbootpractice.model.Student;
import com.app.springbootpractice.repostory.StudentRepository;
import com.app.springbootpractice.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student save(Student user) {
        return studentRepository.save(user);
    }

    @Override
    public Student update(Student integer) {
        return studentRepository.save(integer);
    }

    @Override
    public void delete(Integer integer) {
        Student studentDelete = studentRepository.findById(integer).
                orElseThrow(()-> new RuntimeException("Student not found"));
        studentRepository.delete(studentDelete);
// tra ve optinal
    }

    @Override
    public Student findById(Integer integer) {
        return studentRepository.findById(integer).get();
    }
}
