package com.example.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Getter
@Setter
@ToString
@Table(name = "schools")
@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class School extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @OneToOne(mappedBy = "school")
    private Headmaster headmaster;

    @OneToMany(mappedBy = "school", fetch = FetchType.EAGER)
    private List<Student> students;

    @OneToMany(mappedBy = "school", fetch = FetchType.EAGER)
    private List<Teacher> teachers;

}
