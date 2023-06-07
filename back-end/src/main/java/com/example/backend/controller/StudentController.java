package com.example.backend.controller;

import com.example.backend.dto.StudentDto;
import com.example.backend.dto.converter.ToStudentDtoConverter;
import com.example.backend.entity.Student;
import com.example.backend.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.backend.constants.API.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(STUDENTS_BASE_URI)
public class StudentController {

    private final StudentService studentService;
    private final ToStudentDtoConverter converter;

    @GetMapping(GET_BY_ID_URI)
    public StudentDto getStudentById(@PathVariable Long id) {
        return converter.convert(studentService.getStudentById(id));
    }

    @GetMapping(GET_ALL_URI)
    public List<StudentDto> getAllStudents() {
        return studentService.getAllStudents().stream().map(converter::convert).collect(Collectors.toList());
    }

}
