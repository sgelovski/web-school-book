sap.ui.define([], function () {
    'use strict'
    return {

        formatLogo: function (bIsNightShiftOn) {
            if (bIsNightShiftOn) {
                return "/media/light.svg"
            }

            return "/media/dark.svg"
        },

        formatStudentsNames: function (aStudents) {
            console.error(aStudents);
            let sStudents = "";
            for(let i= 0; i<aStudents.length; i++) {
                sStudents += aStudents[i].name;
                console.error(sStudents);
            }

            return sStudents;
        }
    }
})