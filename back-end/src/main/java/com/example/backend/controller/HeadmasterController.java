package com.example.backend.controller;

import com.example.backend.dto.HeadmasterDto;
import com.example.backend.dto.converter.ToHeadmasterDtoConverter;
import com.example.backend.service.HeadmasterService;
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
@RequestMapping(HEADMASTERS_BASE_URI)
public class HeadmasterController {

    private final HeadmasterService headmasterService;
    private final ToHeadmasterDtoConverter converter;

    @GetMapping(GET_BY_ID_URI)
    public HeadmasterDto getHeadmasterById(@PathVariable Long id) {
        return converter.convert(headmasterService.getHeadmasterById(id));
    }

    @GetMapping(GET_ALL_URI)
    public List<HeadmasterDto> getAllHeadmasters() {
        return headmasterService.getAllHeadmasters().stream().map(converter::convert).collect(Collectors.toList());
    }

}