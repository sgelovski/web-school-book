package com.example.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "students")
@ToString(exclude = {"school", "parents"})
@EqualsAndHashCode(callSuper = true)
public class Student extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "school_class")
    private String schoolClass;

    @JsonIgnore
    @JoinColumn(name = "school_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private School school;

    @ManyToMany(mappedBy = "students")
    private List<Parent> parents;

}
