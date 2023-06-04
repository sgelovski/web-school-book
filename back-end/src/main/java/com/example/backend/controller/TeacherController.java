package com.example.backend.controller;

import com.example.backend.dto.TeacherDto;
import com.example.backend.dto.converter.ToTeacherDtoConverter;
import com.example.backend.service.TeacherService;
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
@RequestMapping(TEACHERS_BASE_URI)
public class TeacherController {

    private final TeacherService teacherService;
    private final ToTeacherDtoConverter converter;

    @GetMapping(GET_ALL_URI)
    public List<TeacherDto> getAllTeachers() {
        return teacherService.getAllTeachers().stream().map(converter::convert).collect(Collectors.toList());
    }

    @GetMapping(GET_BY_ID_URI)
    public TeacherDto getTeacherById(@PathVariable Long id) {
        return converter.convert(teacherService.getTeacherById(id));
    }
}
