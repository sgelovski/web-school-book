package com.example.backend.service.implementations;

import com.example.backend.dto.HeadmasterDto;
import com.example.backend.dto.converter.ToHeadmasterDtoConverter;
import com.example.backend.entity.Headmaster;
import com.example.backend.repository.HeadmasterRepository;
import com.example.backend.service.HeadmasterService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HeadmasterServiceImpl implements HeadmasterService {

    private final HeadmasterRepository headmasterRepository;
    private final ToHeadmasterDtoConverter converter;
    private final ModelMapper modelMapper;

    @Override
    public Headmaster getHeadmasterById(long id) {
        return headmasterRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid headmaster Id: " + id));
    }

    @Override
    public List<Headmaster> getAllHeadmasters() {
        return headmasterRepository.findAll();
    }

    @Override
    public void save(Headmaster headmaster) {
        headmasterRepository.save(headmaster);
    }

    @Override
    public void saveAll(List<Headmaster> headmasterList) {
        headmasterRepository.saveAll(headmasterList);
    }

    @Override
    public Headmaster updateHeadmaster(long id, Headmaster headmaster) {
        headmaster.setId(id);
        return headmasterRepository.save(headmaster);
    }

    private HeadmasterDto convertToSchoolDto(Headmaster headmaster) {
        return modelMapper.map(headmaster, HeadmasterDto.class);
    }
}
