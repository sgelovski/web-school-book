package com.example.backend.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class API {

    public static final String SCHOOLS_BASE_URI = "/schools";
    public static final String HEADMASTERS_BASE_URI = "/headmasters";
    public static final String TEACHERS_BASE_URI = "/teachers";
    public static final String PARENTS_BASE_URI = "/parents";
    public static final String STUDENTS_BASE_URI = "/students";
    public static final String GET_ALL_URI = "/all";
    public static final String GET_BY_ID_URI = "/{id}";
}
