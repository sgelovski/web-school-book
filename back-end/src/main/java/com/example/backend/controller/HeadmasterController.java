package com.example.backend.controller;

import com.example.backend.model.Headmaster;
import com.example.backend.service.HeadmasterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.example.backend.constants.API.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(HEADMASTERS_BASE_URI)
public class HeadmasterController {

    private final HeadmasterService headmasterService;

    @GetMapping(GET_ALL_URI)
    public List<Headmaster> getAllHeadmasters() {
        return headmasterService.getAllHeadmasters();
    }
    @GetMapping(GET_BY_ID_URI)
    public Headmaster getHeadmasterById(@PathVariable Long id) {
        return headmasterService.getHeadmasterById(id);
    }
}