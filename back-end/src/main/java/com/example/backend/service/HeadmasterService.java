package com.example.backend.service;

import com.example.backend.model.Headmaster;

import java.util.List;

public interface HeadmasterService {

    Headmaster getHeadmasterById(long id);

    List<Headmaster> getAllHeadmasters();

    void save(Headmaster headmaster);

    void saveAll(List<Headmaster> headmasterList);

    Headmaster updateHeadmaster(long id, Headmaster headmaster);
}
