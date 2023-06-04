package com.example.backend.dto;

import com.example.backend.entity.School;
import lombok.Builder;

@Builder
public record StudentDto(Long id, String name, String schoolClass, School school) {
}
