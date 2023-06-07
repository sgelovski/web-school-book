package com.example.backend.config;

import com.example.backend.constants.enums.Subject;
import com.example.backend.dto.HeadmasterDto;
import com.example.backend.dto.TeacherDto;
import com.example.backend.dto.converter.ToTeacherDtoConverter;
import com.example.backend.entity.*;
import com.example.backend.service.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class DataImportConfig {

    private final SchoolService schoolService;
    private final HeadmasterService headmasterService;
    private final TeacherService teacherService;
    private final StudentService studentService;
    private final ParentService parentService;
    private final ToTeacherDtoConverter converter;
    private final ModelMapper mapper;


    @Bean
    CommandLineRunner fillDatabase() {
        ObjectMapper mapper = new ObjectMapper().setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
        return args -> {

            School school = new School();
            Teacher teacher = new Teacher();
            Student student = new Student();
            Parent parent = new Parent();
            Headmaster headmaster = new Headmaster();

            school.setName("Sou v levski");
            schoolService.save(school);

            teacher.setName("Iveta");
            teacher.setSubjects(List.of(Subject.PE, Subject.SCIENCE));
            teacher.setSchool(schoolService.getSchoolById(1L));
            teacherService.save(teacher);

            student.setName("Simeon Gelovski");
            student.setSchool(schoolService.getSchoolById(1L));
            studentService.save(student);

            parent.setName("Polina Gelovska");
            parent.setStudents(studentService.getAllStudents());
            parentService.save(parent);

            headmaster.setName("Toma Tomev");
            headmaster.setSchool(schoolService.getSchoolById(1L));
            headmasterService.save(headmaster);



            log.error("school " + schoolService.getSchoolById(1));
            log.error("teacher " + teacherService.getTeacherById(1));

            School school1 = teacherService.getTeacherById(1).getSchool();

            log.error( school1 + "");

        };
    }

    private Teacher convertToTeacher(TeacherDto teacherDto) {
        return mapper.map(teacherDto, Teacher.class);
    }
}
