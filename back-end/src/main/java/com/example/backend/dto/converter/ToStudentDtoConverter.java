package com.example.backend.dto.converter;

import com.example.backend.dto.StudentDto;
import com.example.backend.entity.Student;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ToStudentDtoConverter implements Converter<Student, StudentDto> {
    @Override
    public StudentDto convert(Student source) {
        return StudentDto.builder()
                .id(source.getId())
                .name(source.getName())
                .schoolClass(source.getSchoolClass())
                .school(source.getSchool())
                .build();
    }
}
