package com.example.backend.constants.enums;

import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
public enum Grades {
    EXCELLENT(6),
    VERY_GOOD(5),
    GOOD(4),
    AVERAGE(3),
    POOR(2);

    public final Integer grade;
}
