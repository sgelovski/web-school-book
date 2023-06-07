package com.example.backend.dto;

import com.example.backend.entity.Student;
import lombok.Builder;

import java.util.List;

@Builder
public record ParentDto(Long id, String name, List<Student> students) {
}
