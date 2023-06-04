package com.example.backend.service.implementations;

import com.example.backend.entity.School;
import com.example.backend.repository.SchoolRepository;
import com.example.backend.service.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolServiceImpl implements SchoolService {

    //    private final ModelMapper modelMapper;
    private final SchoolRepository schoolRepository;

    @Override
    public School getSchoolById(long id) {
        return schoolRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid school Id: " + id));
    }

    @Override
    public List<School> getAllSchools() {
        return schoolRepository.findAll();
    }

    @Override
    public void save(School school) {
        schoolRepository.save(school);
    }

    @Override
    public void saveAll(List<School> schoolList) {
        schoolRepository.saveAll(schoolList);
    }

    @Override
    public School updateSchool(long id, School school) {
        school.setId(id);
        return schoolRepository.save(school);
    }

//    private SchoolDto convertToSchoolDto(School school) {
//        return modelMapper.map(school, SchoolDto.class);
//    }
//    private School convertToSchool(SchoolDto schoolDto) {
//        return modelMapper.map(schoolDto, School.class);
//    }
}
