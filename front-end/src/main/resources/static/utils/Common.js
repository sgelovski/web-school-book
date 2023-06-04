sap.ui.define('web/school/book/utils/Common', ['sap/ui/core/UIComponent'], function (UIComponent) {
    'use strict'
    return {
        getModelProperty: function (oScope, sProperty) {
            return oScope.getView().getModel().getProperty(sProperty)
        },
        setModelProperty: function (oScope, sProperty, oValue) {
            oScope.getView().getModel().setProperty(sProperty, oValue)
        },
        openInNewTab: function (sUrl) {
            window.open(sUrl, '_blank');
        }
    }
})
