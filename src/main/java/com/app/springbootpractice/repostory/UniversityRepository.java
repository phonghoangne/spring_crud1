package com.app.springbootpractice.repostory;

import com.app.springbootpractice.model.University;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UniversityRepository extends JpaRepository<University,Integer> {
}
