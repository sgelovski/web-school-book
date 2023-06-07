package com.example.backend.controller;

import com.example.backend.dto.ParentDto;
import com.example.backend.dto.converter.ToParentDtoConverter;
import com.example.backend.entity.Parent;
import com.example.backend.service.ParentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.backend.constants.API.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(PARENTS_BASE_URI)
public class ParentController {

    private final ParentService parentService;
    private final ToParentDtoConverter converter;

    @GetMapping(GET_BY_ID_URI)
    public Parent getParentById(@PathVariable Long id) {
        return parentService.getParentById(id);
    }

    @GetMapping(GET_ALL_URI)
    public List<ParentDto> getAllParents() {
        return parentService.getAllParents().stream().map(converter::convert).collect(Collectors.toList());
    }

}
