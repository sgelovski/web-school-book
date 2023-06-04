package com.example.backend.dto;

import com.example.backend.entity.School;
import lombok.Builder;

@Builder
public record HeadmasterDto(Long id, String name, School school) {
}
