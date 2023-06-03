package com.example.backend.service;

import com.example.backend.model.School;

import java.util.List;

public interface SchoolService {

    School getSchoolById(long id);

    List<School> getAllSchools();

    void save(School school);

    void saveAll(List<School> schoolList);

    School updateSchool(long id, School school);
}
