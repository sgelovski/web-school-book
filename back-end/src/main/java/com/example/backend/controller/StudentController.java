package com.example.backend.controller;

import com.example.backend.model.Student;
import com.example.backend.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.example.backend.constants.API.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(STUDENTS_BASE_URI)
public class StudentController {

    private final StudentService studentService;

    @GetMapping(GET_ALL_URI)
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }
    @GetMapping(GET_BY_ID_URI)
    public Student getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }
}
