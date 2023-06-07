sap.ui.define([
        'sap/m/Label',
        'sap/m/Popover',
        'sap/m/Token',
        "sap/m/MessageToast",
        "sap/m/MessageBox",
        "sap/m/Input",
        "sap/m/Text",
        "sap/m/VBox",
        "sap/m/HBox",
        "sap/m/Button",
        'sap/ui/core/library',
        'sap/ui/core/format/DateFormat',
        'sap/ui/core/Fragment',
        'sap/ui/core/mvc/Controller',
        'sap/ui/model/json/JSONModel',
        'sap/ui/webc/main/Checkbox',
        'sap/base/Log',
        'web/school/book/utils/Constants',
        'web/school/book/utils/Common',
        'web/school/book/model/formatter',
        'web/school/book/handlers/HttpHandler',
        'sap/ui/model/Filter',
        'sap/ui/model/FilterOperator',
        'sap/ui/model/Sorter',
        'sap/ui/core/IconPool'
    ],


    function (Label, Popover, Token, MessageToast, MessageBox, Input, Text, VBox, HBox, Button, coreLibrary, DateFormat, Fragment, Controller, JSONModel, Checkbox, Log, Constants, Common, formatter, HttpHandler, Filter, FilterOperator, Sorter, IconPool) {
        "use strict";

        return Controller.extend("web.school.book.controller.Page", {

            formatter: formatter,

            onInit: function () {

                let oData = {
                        isNightShiftOn: false,
                        menuData: Constants.MENU,
                        schools: [],
                        teachers: [],
                        headmasters: [],
                        students: [],
                        parents: [],
                    },
                    oView = this.getView();

                console.error(oData);

                let oModel = new JSONModel(oData);
                oModel.setSizeLimit(Number.MAX_VALUE);
                oView.setModel(oModel);


                Promise.all(
                    [
                        this._getAllByEntity(Constants.API.SCHOOLS_URI, "/schools"),
                        this._getAllByEntity(Constants.API.HEADMASTERS_URI, "/headmasters"),
                        this._getAllByEntity(Constants.API.TEACHERS_URI, "/teachers"),
                        this._getAllByEntity(Constants.API.STUDENTS_URI, "/students"),
                        this._getAllByEntity(Constants.API.PARENTS_URI, "/parents")
                    ]).catch(err => console.error("Initial fetch - " + err));


                if (!this._pMenu) {
                    this._pMenu = Fragment.load({
                        id: oView.getId(),
                        name: "web.school.book.fragment.Menu",
                        controller: this
                    }).then(function (oMenu) {
                        oView.addDependent(oMenu);
                        return oMenu;
                    }.bind(this));
                }


            },

            _getAllByEntity: async function (sUri, sProperty) {
                const entityArray = await HttpHandler.executeGetRequest(sUri + '/all');
                Common.setModelProperty(this, sProperty, entityArray);
            },

            toggleNightShift: function (oEvent) {
                const bIsNightShiftOn = oEvent.getSource().getState();
                this._switchNightShift(bIsNightShiftOn);
            },

            _switchNightShift: function (bIsNightShiftOn) {
                const sTheme = bIsNightShiftOn ? Constants.THEME.DARK : Constants.THEME.LIGHT;
                sap.ui.getCore().applyTheme(sTheme);
                Common.setModelProperty(this, '/isNightShiftOn', bIsNightShiftOn);
            },

            onNavigationFinished: function (evt) {
                let toPage = evt.getParameter("to");
                MessageToast.show("Navigation to page '" + toPage.getTitle() + "' finished");
            },

            handleNav: function (evt) {
                let navCon = this.byId("navCon");
                let target = evt.getSource().data("target");
                if (target) {
                    // let animation = this.byId("animationSelect").getSelectedKey();
                    navCon.to(this.byId(target));
                } else {
                    navCon.back();
                }
            },

            fnChange: function (oEvent) {
                let navCon = this.byId("navCon");
                navCon.to(this.byId(oEvent.getParameter("itemPressed").getTarget()));
                MessageToast.show("Change event was fired from " + oEvent.getParameter("itemPressed").getId() + ". It has targetSrc: " + oEvent.getParameter("itemPressed").getTargetSrc() + " and target: " + oEvent.getParameter("itemPressed").getTarget() + ".");
            },

            fnOpen: function (oEvent) {
                debugger;
                let oButton = oEvent.getSource();
                this._pMenu.then(function (oMenu) {
                    oMenu.openBy(oButton);
                });
            },

            fnClose: function () {
                this._pMenu.then(function (oMenu) {
                    oMenu.close();
                });
            }


        });
    });