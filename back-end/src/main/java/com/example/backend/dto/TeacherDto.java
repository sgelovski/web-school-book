package com.example.backend.dto;

import com.example.backend.constants.enums.Subject;
import com.example.backend.entity.School;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
public record TeacherDto(Long id, String name, List<Subject> subjects, School school) {
}
