package com.example.backend.dto.converter;

import com.example.backend.dto.TeacherDto;
import com.example.backend.entity.Teacher;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ToTeacherDtoConverter implements Converter<Teacher, TeacherDto> {
    @Override
    public TeacherDto convert(Teacher source) {
        return TeacherDto.builder()
                .id(source.getId())
                .name(source.getName())
                .subjects(source.getSubjects())
                .school(source.getSchool())
                .build();
    }
}
