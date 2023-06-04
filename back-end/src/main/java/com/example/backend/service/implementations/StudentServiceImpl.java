package com.example.backend.service.implementations;

import com.example.backend.entity.Student;
import com.example.backend.repository.StudentRepository;
import com.example.backend.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    @Override
    public Student getStudentById(long id) {
        return studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid student Id: " + id));
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void saveAll(List<Student> studentList) {
        studentRepository.saveAll(studentList);
    }

    @Override
    public Student updateStudent(long id, Student student) {
        student.setId(id);
        return studentRepository.save(student);
    }
}
