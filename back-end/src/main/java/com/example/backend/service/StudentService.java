package com.example.backend.service;

import com.example.backend.model.Student;

import java.util.List;

public interface StudentService {
    Student getStudentById(long id);

    List<Student> getAllStudents();

    void save(Student student);

    void saveAll(List<Student> studentList);

    Student updateStudent(long id, Student student);
}
