package com.example.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Headmaster extends BaseEntity {

    private String name;

    @JsonIgnore
    @OneToOne(mappedBy = "headmaster")
    private School school;

}
