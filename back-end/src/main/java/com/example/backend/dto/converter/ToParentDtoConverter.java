package com.example.backend.dto.converter;

import com.example.backend.dto.ParentDto;
import com.example.backend.entity.Parent;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ToParentDtoConverter implements Converter<Parent, ParentDto> {

    @Override
    public ParentDto convert(Parent source) {
        return ParentDto.builder()
                .id(source.getId())
                .name(source.getName())
                .students(source.getStudents())
                .build();
    }

}
