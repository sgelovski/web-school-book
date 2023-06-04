package com.example.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Builder;
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

    @JsonIgnore
    @OneToMany(mappedBy = "school")
    private List<Student> students;

    @JsonIgnore
    @OneToMany(mappedBy = "school")
    private List<Teacher> teachers;

}
