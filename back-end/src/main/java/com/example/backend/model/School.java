package com.example.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class School extends BaseEntity {

    private String name;

    private String address;

    @OneToOne
    private Headmaster headmaster;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Student> students;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Teacher> teachers;

}
