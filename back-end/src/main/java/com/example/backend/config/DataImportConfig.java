package com.example.backend.config;

import com.example.backend.dto.TeacherDto;
import com.example.backend.dto.converter.ToTeacherDtoConverter;
import com.example.backend.entity.School;
import com.example.backend.entity.Teacher;
import com.example.backend.service.HeadmasterService;
import com.example.backend.service.SchoolService;
import com.example.backend.service.StudentService;
import com.example.backend.service.TeacherService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class DataImportConfig {

    private final SchoolService schoolService;
    private final HeadmasterService headmasterService;
    private final TeacherService teacherService;
    private final StudentService studentService;
    private final ToTeacherDtoConverter converter;
    private final ModelMapper mapper;


    @Bean
    CommandLineRunner fillDatabase() {
        ObjectMapper mapper = new ObjectMapper().setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
        return args -> {
//            try {
//            schoolService.saveAll(mapper.readValue(TypeReference.class.getResourceAsStream("/json/schools.json"), new TypeReference<>() {}));
//            headmasterService.saveAll(mapper.readValue(TypeReference.class.getResourceAsStream("/json/headmasters.json"), new TypeReference<>() {}));
//            teacherService.saveAll(mapper.readValue(TypeReference.class.getResourceAsStream("/json/teachers.json"), new TypeReference<>() {}));
//            studentService.saveAll(mapper.readValue(TypeReference.class.getResourceAsStream("/json/students.json"), new TypeReference<>() {}));
//
//
//            School school = schoolService.getSchoolById(1);
//            Teacher teacher = teacherService.getTeacherById(1);
//            Student student = studentService.getStudentById(1);
//
//            school.setHeadmaster(headmasterService.getHeadmasterById(1));
//            teacher.setSchool(school);
//            student.setSchool(school);
//
//            studentService.save(student);
//            teacherService.save(teacher);
//            schoolService.save(school);
//
//            log.error("" + headmasterService.getHeadmasterById(1).getSchool().getAddress());
//            log.error("" + schoolService.getSchoolById(1).getTeachers());
//
//            log.info("Entities saved successfully");
//            } catch (IOException e) {
//                log.error("Unable to save entities");
//            }

            School school = new School();
            Teacher teacher = new Teacher();

            school.setName("Sou v levski");
            schoolService.save(school);

            teacher.setName("Iveta");
            teacher.setSchool(schoolService.getSchoolById(1L));
            teacherService.save(teacher);


            log.error("school " + schoolService.getSchoolById(1));
            log.error("teacher " + teacherService.getTeacherById(1));

            log.error(teacherService.getTeacherById(1).getSchool() + "");

        };
    }

    private Teacher convertToTeacher(TeacherDto teacherDto) {
        return mapper.map(teacherDto, Teacher.class);
    }
}
