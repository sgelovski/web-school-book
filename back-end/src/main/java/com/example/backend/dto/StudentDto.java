package com.example.backend.dto;

import com.example.backend.entity.Parent;
import com.example.backend.entity.School;
import lombok.Builder;

import java.util.List;

@Builder
public record StudentDto(Long id, String name, String schoolClass, School school, List<Parent> parents) {
}
