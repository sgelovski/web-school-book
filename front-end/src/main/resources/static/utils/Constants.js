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
            "subTitle": "Central Home"
        },
        {
            "src": "sap-icon://company-view",
            "title": "Teachers",
            "subTitle": "School Teachers"
        }
    ]

    return {
        API: API,
        THEME: THEME,
        MENU: MENU
    }
})