package com.example.backend.model;

import jakarta.persistence.Entity;
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
    private School school;

}
