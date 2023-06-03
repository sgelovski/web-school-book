package com.example.backend.service;

import com.example.backend.model.Teacher;

import java.util.List;

public interface TeacherService {

    Teacher getTeacherById(long id);

    List<Teacher> getAllTeachers();

    void save(Teacher school);

    void saveAll(List<Teacher> teacherList);

    Teacher updateTeacher(long id, Teacher teacher);
}
