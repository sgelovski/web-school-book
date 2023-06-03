package com.example.backend.service.implementations;

import com.example.backend.model.Teacher;
import com.example.backend.repository.TeacherRepository;
import com.example.backend.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;

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
