package com.example.backend.entity;

import com.example.backend.constants.enums.Subject;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Getter
@Setter
@ToString(exclude = "school")
@Table(name = "teachers")
@EqualsAndHashCode(callSuper = true)
public class Teacher extends BaseEntity {

    @Column(name = "name")
    private String name;

    private List<Subject> subjects;

    @JsonIgnore
    @JoinColumn(name = "school_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private School school;

}
