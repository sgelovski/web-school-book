package com.example.backend.dto.converter;

import com.example.backend.dto.HeadmasterDto;
import com.example.backend.entity.Headmaster;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ToHeadmasterDtoConverter implements Converter<Headmaster, HeadmasterDto> {

    @Override
    public HeadmasterDto convert(Headmaster source) {
        return HeadmasterDto.builder()
                .id(source.getId())
                .name(source.getName())
                .school(source.getSchool())
                .build();
    }
}
