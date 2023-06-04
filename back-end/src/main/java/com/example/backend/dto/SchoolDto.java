package com.example.backend.dto;

import com.example.backend.entity.Headmaster;
import com.example.backend.entity.Student;
import com.example.backend.entity.Teacher;
import lombok.Builder;

import java.util.List;

@Builder
public record SchoolDto(Long id, String name, String address, Headmaster headmaster, List<Teacher> teachers, List<Student> students) {
}
