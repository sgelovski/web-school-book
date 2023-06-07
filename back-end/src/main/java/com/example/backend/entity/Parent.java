package com.example.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class Parent extends BaseEntity {

    private String name;


    @JsonIgnore
    @JoinColumn(name = "school_id")
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Student> students;

}
