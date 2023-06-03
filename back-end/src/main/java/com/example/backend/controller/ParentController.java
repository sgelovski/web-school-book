package com.example.backend.controller;

import com.example.backend.model.Parent;
import com.example.backend.service.ParentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.example.backend.constants.API.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(PARENTS_BASE_URI)
public class ParentController {

    private final ParentService parentService;

    @GetMapping(GET_ALL_URI)
    public List<Parent> getAllParents() {
        return parentService.getAllParents();
    }

    @GetMapping(GET_BY_ID_URI)
    public Parent getAllParents(@PathVariable Long id) {
        return parentService.getParentById(id);
    }
}
