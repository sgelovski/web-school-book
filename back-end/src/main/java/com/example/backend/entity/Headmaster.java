package com.example.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name = "headmaster")
@ToString(exclude = "school")
@EqualsAndHashCode(callSuper = true)
public class Headmaster extends BaseEntity {

    @Column(name = "name")
    private String name;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "school_id")
    private School school;

}
