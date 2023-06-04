package com.example.backend.service.implementations;

import com.example.backend.dto.TeacherDto;
import com.example.backend.dto.converter.ToTeacherDtoConverter;
import com.example.backend.entity.Teacher;
import com.example.backend.repository.TeacherRepository;
import com.example.backend.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;
    private final ToTeacherDtoConverter converter;

    @Override
    public Teacher getTeacherById(long id) {
        return teacherRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid teacher Id: " + id));
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    @Override
    public void save(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    @Override
    public void saveAll(List<Teacher> teacherList) {
        teacherRepository.saveAll(teacherList);
    }

    @Override
    public Teacher updateTeacher(long id, Teacher teacher) {
        teacher.setId(id);
        return teacherRepository.save(teacher);
    }
}
