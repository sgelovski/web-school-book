package com.example.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Entity
@ToString
@Table(name = "schools")
@EqualsAndHashCode(callSuper = true)
public class School extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @OneToOne
    private Headmaster headmaster;

    @OneToMany(mappedBy = "school", fetch = FetchType.EAGER)
    private List<Student> students;

    @OneToMany(mappedBy = "school", fetch = FetchType.EAGER)
    private List<Teacher> teachers;

}
