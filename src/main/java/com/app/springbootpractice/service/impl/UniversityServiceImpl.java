package com.app.springbootpractice.service.impl;

import com.app.springbootpractice.model.University;
import com.app.springbootpractice.repostory.UniversityRepository;
import com.app.springbootpractice.service.UniversityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class UniversityServiceImpl implements UniversityService {
    private final UniversityRepository universityRepository;

    @Override
    public List<University> findAll() {
        List<University> universities = universityRepository.findAll();
        return universities;
    }

    @Override
    public University save(University user) {
        return universityRepository.save(user);
    }

    @Override
    public University update(University university) {
      University universityUpdate = universityRepository.save(university);
      return universityUpdate;
    }

    @Override
    public void delete(Integer integer) {
        University universityDelete = universityRepository.findById(integer).
                orElseThrow(()-> new RuntimeException("u not found"));
        universityRepository.delete(universityDelete);

    }

    @Override
    public University findById(Integer integer) {
        return universityRepository.findById(integer).orElseThrow(()-> new RuntimeException("u not found"));
    }
}
