//package com.example.backend.dto.converter;
//
//import com.example.backend.dto.TeacherDto;
//import com.example.backend.entity.Teacher;
//import org.springframework.core.convert.converter.Converter;
//import org.springframework.stereotype.Component;
//
//@Component
//public class ToTeacherConverter implements Converter<TeacherDto, Teacher> {
//    @Override
//    public Teacher convert(TeacherDto source) {
//        return Teacher.builder()
//                .name(source.name())
//                .subjects(source.subjects())
//                .school(source.school()).build();
//    }
//}
