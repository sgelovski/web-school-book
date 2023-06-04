package com.example.backend.service;

import com.example.backend.entity.Parent;

import java.util.List;

public interface ParentService {
    Parent getParentById(long id);

    List<Parent> getAllParents();

    void save(Parent parent);

    void saveAll(List<Parent> parentList);

    Parent updateParent(long id, Parent parent);
}
