package com.example.backend.service.implementations;

import com.example.backend.model.Headmaster;
import com.example.backend.repository.HeadmasterRepository;
import com.example.backend.service.HeadmasterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HeadmasterServiceImpl implements HeadmasterService {

    private final HeadmasterRepository headmasterRepository;

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
}
