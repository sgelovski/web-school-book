sap.ui.define([], function () {
    'use strict'
    return {

        formatLogo: function (bIsNightShiftOn){
            if (bIsNightShiftOn) {
                return "/media/light.svg"
            }

            return "/media/dark.svg"
        }
    }
})