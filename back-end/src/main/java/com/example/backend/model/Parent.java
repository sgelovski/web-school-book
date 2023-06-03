package com.example.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Parent extends BaseEntity {

    private String name;

    @ManyToMany
    private List<Student> students;

}
