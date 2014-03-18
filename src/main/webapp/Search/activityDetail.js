/*
 * JS for activityDetail generated by Appery.io
 *
 */

Appery.getProjectGUID = function() {
    return 'abfa3b56-b56f-4a15-ac55-911de764ccdf';
}

function navigateTo(outcome, useAjax) {
    Appery.navigateTo(outcome, useAjax);
}

// Deprecated


function adjustContentHeight() {
    Appery.adjustContentHeightWithPadding();
}

function adjustContentHeightWithPadding(_page) {
    Appery.adjustContentHeightWithPadding(_page);
}

function setDetailContent(pageUrl) {
    Appery.setDetailContent(pageUrl);
}

Appery.AppPages = [{
    "name": "mapPage",
    "location": "mapPage.html"
}, {
    "name": "activityDetail",
    "location": "activityDetail.html"
}, {
    "name": "profile",
    "location": "profile.html"
}];

activityDetail_js = function(runBeforeShow) { /* Object & array with components "name-to-id" mapping */
    var n2id_buf = {
        'bigGrid': 'activityDetail_bigGrid',
        'mobilegridcell_29': 'activityDetail_mobilegridcell_29',
        'mobilegrid_38': 'activityDetail_mobilegrid_38',
        'mobilegridcell_39': 'activityDetail_mobilegridcell_39',
        'lblActivityLongName': 'activityDetail_lblActivityLongName',
        'mobilegridcell_41': 'activityDetail_mobilegridcell_41',
        'lblActivityDescription': 'activityDetail_lblActivityDescription',
        'mobilegridcell_33': 'activityDetail_mobilegridcell_33',
        'mobilegrid_45': 'activityDetail_mobilegrid_45',
        'mobilegridcell_46': 'activityDetail_mobilegridcell_46',
        'mobilegrid_50': 'activityDetail_mobilegrid_50',
        'mobilegridcell_51': 'activityDetail_mobilegridcell_51',
        'lblAgeLabel': 'activityDetail_lblAgeLabel',
        'mobilegridcell_52': 'activityDetail_mobilegridcell_52',
        'lblDisplayAgeRange': 'activityDetail_lblDisplayAgeRange',
        'mobilegridcell_47': 'activityDetail_mobilegridcell_47',
        'mobilegrid_57': 'activityDetail_mobilegrid_57',
        'mobilegridcell_58': 'activityDetail_mobilegridcell_58',
        'lblTypeLabel': 'activityDetail_lblTypeLabel',
        'mobilegridcell_59': 'activityDetail_mobilegridcell_59',
        'lblDisplayType': 'activityDetail_lblDisplayType',
        'mobilegridcell_48': 'activityDetail_mobilegridcell_48',
        'mobilegrid_70': 'activityDetail_mobilegrid_70',
        'mobilegridcell_71': 'activityDetail_mobilegridcell_71',
        'ldblDayLabel': 'activityDetail_ldblDayLabel',
        'mobilegridcell_72': 'activityDetail_mobilegridcell_72',
        'lblDisplayDay': 'activityDetail_lblDisplayDay',
        'mobilegridcell_49': 'activityDetail_mobilegridcell_49',
        'mobilegrid_77': 'activityDetail_mobilegrid_77',
        'mobilegridcell_78': 'activityDetail_mobilegridcell_78',
        'lblDisplayTimeStart': 'activityDetail_lblDisplayTimeStart',
        'mobilegridcell_79': 'activityDetail_mobilegridcell_79',
        'lblDisplayTimeEnd': 'activityDetail_lblDisplayTimeEnd',
        'mobilegridcell_35': 'activityDetail_mobilegridcell_35',
        'mobilegrid_64': 'activityDetail_mobilegrid_64',
        'mobilegridcell_65': 'activityDetail_mobilegridcell_65',
        'lblDisplayNarrative': 'activityDetail_lblDisplayNarrative',
        'mobilegridcell_37': 'activityDetail_mobilegridcell_37',
        'mobilecheckboxgroup_85': 'activityDetail_mobilecheckboxgroup_85',
        'chkFree': 'activityDetail_chkFree',
        'chkBooking': 'activityDetail_chkBooking',
        'chkLimitedPlaces': 'activityDetail_chkLimitedPlaces',
        'mobilegridcell_89': 'activityDetail_mobilegridcell_89',
        'mobilecollapsblock_90': 'activityDetail_mobilecollapsblock_90',
        'collapseHdrVenueName': 'activityDetail_collapseHdrVenueName',
        'collapseHdrVenueContent': 'activityDetail_collapseHdrVenueContent',
        'grdAddress': 'activityDetail_grdAddress',
        'mobilegridcell_94': 'activityDetail_mobilegridcell_94',
        'mobilegrid_99': 'activityDetail_mobilegrid_99',
        'mobilegridcell_100': 'activityDetail_mobilegridcell_100',
        'lblVenueAddress': 'activityDetail_lblVenueAddress',
        'mobilegridcell_102': 'activityDetail_mobilegridcell_102',
        'lblVenueBorough': 'activityDetail_lblVenueBorough',
        'lblVenuePostCode': 'activityDetail_lblVenuePostCode',
        'mobilegridcell_104': 'activityDetail_mobilegridcell_104',
        'lblVenueAccess': 'activityDetail_lblVenueAccess',
        'mobilegridcell_96': 'activityDetail_mobilegridcell_96',
        'mobilegrid_110': 'activityDetail_mobilegrid_110',
        'grdCellTransport': 'activityDetail_grdCellTransport',
        'lblTransport': 'activityDetail_lblTransport',
        'mobilegridcell_112': 'activityDetail_mobilegridcell_112',
        'lblVenueTransport': 'activityDetail_lblVenueTransport',
        'mobilegridcell_109': 'activityDetail_mobilegridcell_109',
        'mobilecheckboxgroup_117': 'activityDetail_mobilecheckboxgroup_117',
        'chkBabyChanging': 'activityDetail_chkBabyChanging',
        'chkBottleWarming': 'activityDetail_chkBottleWarming',
        'chkLiftAccess': 'activityDetail_chkLiftAccess',
        'chkStepFree': 'activityDetail_chkStepFree',
        'chkRefreshments': 'activityDetail_chkRefreshments',
        'chkBuggyParking': 'activityDetail_chkBuggyParking',
        'chkBreastFeeding': 'activityDetail_chkBreastFeeding',
        'chkVendingMachine': 'activityDetail_chkVendingMachine',
        'lblId': 'activityDetail_lblId',
        'lblVenueId': 'activityDetail_lblVenueId'
    };

    if ("n2id" in window && window.n2id !== undefined) {
        $.extend(n2id, n2id_buf);
    } else {
        window.n2id = n2id_buf;
    }

    if (navigator.userAgent.indexOf("IEMobile") != -1) {
        //Fixing issue https://github.com/jquery/jquery-mobile/issues/5424 on Windows Phone
        $("div[data-role=page] div[data-role=footer]").css("bottom", "-36px");
    }

    if (Appery.getTargetPlatform == "I") {
        $.each(window.n2id, function(name, id) {
            var elApperyRole = $("#" + id).attr("data-role");
            if (elApperyRole != "appery_label" && elApperyRole != "appery_link") {
                var appleDataSelector = "#" + id + "[x-apple-data-detectors], #" + id + " [x-apple-data-detectors]";
                $(appleDataSelector).attr("x-apple-data-detectors", "false");
            }
        });
    }

    Appery.CurrentScreen = 'activityDetail';

    /*
     * Nonvisual components
     */
    var datasources = [];

    KCActivityDetail = new Appery.DataSource(KCActivityDetailService, {
        'onComplete': function(jqXHR, textStatus) {

            $t.refreshScreenFormElements("activityDetail");
        },
        'onSuccess': function(data) {},
        'onError': function(jqXHR, textStatus, errorThrown) {},
        'responseMapping': [{
            'PATH': ['activity', 'displayAgeRange'],
            'ID': 'lblDisplayAgeRange',
            'ATTR': '@'
        }, {
            'PATH': ['activity', 'displayDay'],
            'ID': 'lblDisplayDay',
            'ATTR': '@'
        }, {
            'PATH': ['activity', 'narrative'],
            'ID': 'lblDisplayNarrative',
            'ATTR': '@'
        }, {
            'PATH': ['activity', 'bookingRequired'],
            'ID': 'chkBooking',
            'ATTR': 'checked'
        }, {
            'PATH': ['activity', 'freeOfCharge'],
            'ID': 'chkFree',
            'ATTR': 'checked'
        }, {
            'PATH': ['activity', 'limitedCapacity'],
            'ID': 'chkLimitedPlaces',
            'ATTR': 'checked'
        }, {
            'PATH': ['activity', 'description'],
            'ID': 'lblActivityDescription',
            'ATTR': '@'
        }, {
            'PATH': ['activity', 'end'],
            'ID': 'lblDisplayTimeEnd',
            'ATTR': '@'
        }, {
            'PATH': ['activity', 'start'],
            'ID': 'lblDisplayTimeStart',
            'ATTR': '@'
        }, {
            'PATH': ['activity', 'name'],
            'ID': 'lblActivityLongName',
            'ATTR': '@'
        }, {
            'PATH': ['activity', 'type'],
            'ID': 'lblDisplayType',
            'ATTR': '@'
        }, {
            'PATH': ['venue', 'access'],
            'ID': 'lblVenueAccess',
            'ATTR': '@'
        }, {
            'PATH': ['venue', 'babyChange'],
            'ID': 'chkBabyChanging',
            'ATTR': 'checked'
        }, {
            'PATH': ['venue', 'liftAccess'],
            'ID': 'chkLiftAccess',
            'ATTR': 'checked'
        }, {
            'PATH': ['venue', 'bottleWarming'],
            'ID': 'chkBottleWarming',
            'ATTR': 'checked'
        }, {
            'PATH': ['venue', 'vendingMachine'],
            'ID': 'chkVendingMachine',
            'ATTR': 'checked'
        }, {
            'PATH': ['venue', 'stepFree'],
            'ID': 'chkStepFree',
            'ATTR': 'checked'
        }, {
            'PATH': ['venue', 'refreshments'],
            'ID': 'chkRefreshments',
            'ATTR': 'checked'
        }, {
            'PATH': ['venue', 'transport'],
            'ID': 'lblVenueTransport',
            'ATTR': '@'
        }, {
            'PATH': ['venue', 'buggyParking'],
            'ID': 'chkBuggyParking',
            'ATTR': 'checked'
        }, {
            'PATH': ['venue', 'breastFeeding'],
            'ID': 'chkBreastFeeding',
            'ATTR': 'checked'
        }, {
            'PATH': ['venue', 'address'],
            'ID': 'lblVenueAddress',
            'ATTR': '@'
        }, {
            'PATH': ['venue', 'name'],
            'ID': 'collapseHdrVenueName',
            'ATTR': '@'
        }, {
            'PATH': ['venue', 'borough', 'name'],
            'ID': 'lblVenueBorough',
            'ATTR': '@'
        }, {
            'PATH': ['venue', 'postCode', 'code'],
            'ID': 'lblVenuePostCode',
            'ATTR': '@'
        }],
        'requestMapping': [{
            'PATH': ['activity-id'],
            'TYPE': 'STRING',
            'ID': 'lblId',
            'ATTR': '@'
        }]
    });

    datasources.push(KCActivityDetail);

    /*
     * Events and handlers
     */

    // Before Show
    activityDetail_beforeshow = function() {
        Appery.CurrentScreen = "activityDetail";
        for (var idx = 0; idx < datasources.length; idx++) {
            datasources[idx].__setupDisplay();
        }
    }

    // On Load
    screen_3671_onLoad = activityDetail_onLoad = function() {
        screen_3671_elementsExtraJS();
        setText('activityDetail_lblId', localStorage.getItem('activityIdentifier'));
        try {
            KCActivityDetail.execute({})
        } catch (ex) {
            console.log(ex.name + '  ' + ex.message);
            hideSpinner();
        };

        // TODO fire device events only if necessary (with JS logic)
        activityDetail_deviceEvents();
        activityDetail_windowEvents();
        screen_3671_elementsEvents();
    }

    // screen window events
    screen_3671_windowEvents = activityDetail_windowEvents = function() {

        $('#activityDetail').bind('pageshow orientationchange', function() {
            var _page = this;
            adjustContentHeightWithPadding(_page);
        });

    }

    // device events
    activityDetail_deviceEvents = function() {

        document.addEventListener("deviceready", function() {

        });
    }

    // screen elements extra js
    screen_3671_elementsExtraJS = activityDetail_elementsExtraJS = function() {
        // screen (activityDetail) extra code

        /* mobilecollapsblock_90 */

        $("#activityDetail_mobilecollapsblock_90 .ui-collapsible-heading-toggle").attr("tabindex", "2");

    }

    // screen elements handler
    screen_3671_elementsEvents = activityDetail_elementsEvents = function() {

        $("a :input,a a,a fieldset label").live({
            click: function(event) {
                event.stopPropagation();
            }
        });

    }

    $("#activityDetail").die("pagebeforeshow").live("pagebeforeshow", function(event, ui) {
        activityDetail_beforeshow();
    });

    if (runBeforeShow) {
        activityDetail_beforeshow();
    } else {
        activityDetail_onLoad();
    }

}

$("#activityDetail").die("pageinit").live("pageinit", function(event, ui) {
    Appery.processSelectMenu($(this));
    activityDetail_js();
});