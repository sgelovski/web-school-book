sap.ui.define([], function () {
    "use strict";

    const API = {
        SCHOOLS_URI: 'http://localhost:8080/schools',
        HEADMASTERS_URI: 'http://localhost:8080/headmasters',
        TEACHERS_URI: 'http://localhost:8080/teachers',
        STUDENTS_URI: 'http://localhost:8080/students',
        PARENTS_URI: 'http://localhost:8080/parents'
    }

    const THEME = {
        LIGHT: 'sap_horizon',
        DARK: 'sap_horizon_dark',
    }

    let MENU = [
        {
            "src": "sap-icon://home",
            "title": "Home",
            "target": "HomeId"
        },
        {
            "src": "sap-icon://company-view",
            "title": "Teachers",
            "subTitle": "School Teachers",
            "target": "TeachersId"
        },
        {
            "src": "sap-icon://company-view",
            "title": "Students",
            "subTitle": "School Students",
            "target": "StudentsId"
        },
        {
            "src": "sap-icon://official-service",
            "title": "Schools",
            "subTitle": "All Schools",
            "target": "SchoolsId"
        },
        {
            "src": "sap-icon://study-leave",
            "title": "Headmasters",
            "subTitle": "School Headmasters",
            "target": "HeadmastersId"
        },
        {
            "src": "sap-icon://group",
            "title": "Parents",
            "subTitle": "Students Parents",
            "target": "ParentsId"
        }

    ]

    return {
        API: API,
        THEME: THEME,
        MENU: MENU
    }
})