package com.example.backend.controller;

import com.example.backend.model.Teacher;
import com.example.backend.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.example.backend.constants.API.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(TEACHERS_BASE_URI)
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping(GET_ALL_URI)
    public List<Teacher> getAllTeachers() {
        return teacherService.getAllTeachers();
    }

    @GetMapping(GET_BY_ID_URI)
    public Teacher getTeacherById(@PathVariable Long id) {
        return teacherService.getTeacherById(id);
    }
}
