package com.example.backend.service.implementations;

import com.example.backend.model.Parent;
import com.example.backend.repository.ParentRepository;
import com.example.backend.service.ParentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ParentServiceImpl implements ParentService {

    private final ParentRepository parentRepository;

    @Override
    public Parent getParentById(long id) {
        return parentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid parent Id: " + id));
    }

    @Override
    public List<Parent> getAllParents() {
        return parentRepository.findAll();
    }

    @Override
    public void save(Parent parent) {
        parentRepository.save(parent);
    }

    @Override
    public void saveAll(List<Parent> parentList) {
        parentRepository.saveAll(parentList);
    }

    @Override
    public Parent updateParent(long id, Parent parent) {
        parent.setId(id);
        return parentRepository.save(parent);
    }
}
