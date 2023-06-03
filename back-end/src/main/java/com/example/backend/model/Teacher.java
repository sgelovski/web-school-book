package com.example.backend.model;

import com.example.backend.constants.enums.Subject;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Teacher extends BaseEntity {

    private String name;

    private List<Subject> subjects;

    @ManyToOne
    private School school;

}
