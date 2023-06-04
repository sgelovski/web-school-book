package com.example.backend.controller;

import com.example.backend.entity.School;
import com.example.backend.service.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.example.backend.constants.API.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(SCHOOLS_BASE_URI)
public class SchoolController {

    private final SchoolService schoolService;

    @GetMapping(GET_ALL_URI)
    public List<School> getAllSchools() {
        return schoolService.getAllSchools();
    }

    @GetMapping(GET_BY_ID_URI)
    public School getAllSchools(@PathVariable Long id) {
        return schoolService.getSchoolById(id);
    }
}
