package com.example.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Student extends BaseEntity {

    private String name;

    private String schoolClass;

    @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;

}
