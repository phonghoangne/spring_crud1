package com.app.springbootpractice.repostory;

import com.app.springbootpractice.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {
}
