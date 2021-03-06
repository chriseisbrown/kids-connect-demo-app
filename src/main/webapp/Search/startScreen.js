/*
 * JS for profile generated by Appery.io
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

profile_js = function(runBeforeShow) { /* Object & array with components "name-to-id" mapping */
    var n2id_buf = {
        'mobilegrid_1': 'profile_mobilegrid_1',
        'mobilegridcell_2': 'profile_mobilegridcell_2',
        'lblUserName': 'profile_lblUserName',
        'mobilegridcell_3': 'profile_mobilegridcell_3',
        'lblUser': 'profile_lblUser',
        'mobilegridcell_4': 'profile_mobilegridcell_4',
        'mobilelabel_19': 'profile_mobilelabel_19',
        'mobilegridcell_5': 'profile_mobilegridcell_5',
        'txtDisplayName': 'profile_txtDisplayName',
        'mobilegridcell_6': 'profile_mobilegridcell_6',
        'lblPostCode': 'profile_lblPostCode',
        'mobilegridcell_7': 'profile_mobilegridcell_7',
        'txtPostCode': 'profile_txtPostCode',
        'mobilegridcell_8': 'profile_mobilegridcell_8',
        'mobilegridcell_9': 'profile_mobilegridcell_9',
        'mobilegridcell_99': 'profile_mobilegridcell_99',
        'chkgrpBuddy': 'profile_chkgrpBuddy',
        'chkBuddy': 'profile_chkBuddy',
        'btnProfileChanges': 'profile_btnProfileChanges'
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

    Appery.CurrentScreen = 'profile';

    /*
     * Nonvisual components
     */
    var datasources = [];

    /*
     * Events and handlers
     */

    // Before Show
    profile_beforeshow = function() {
        Appery.CurrentScreen = "profile";
        for (var idx = 0; idx < datasources.length; idx++) {
            datasources[idx].__setupDisplay();
        }
    }

    // On Load
    screen_D828_onLoad = profile_onLoad = function() {
        screen_D828_elementsExtraJS();
        $("#txtPostCode").attr("disabled", true);;

        // TODO fire device events only if necessary (with JS logic)
        profile_deviceEvents();
        profile_windowEvents();
        screen_D828_elementsEvents();
    }

    // screen window events
    screen_D828_windowEvents = profile_windowEvents = function() {

        $('#profile').bind('pageshow orientationchange', function() {
            var _page = this;
            adjustContentHeightWithPadding(_page);
        });

    }

    // device events
    profile_deviceEvents = function() {

        document.addEventListener("deviceready", function() {

        });
    }

    // screen elements extra js
    screen_D828_elementsExtraJS = profile_elementsExtraJS = function() {
        // screen (profile) extra code

    }

    // screen elements handler
    screen_D828_elementsEvents = profile_elementsEvents = function() {

        $("a :input,a a,a fieldset label").live({
            click: function(event) {
                event.stopPropagation();
            }
        });
        
        
        $('[name="btnProfileChanges"]').die().live({
            click: function() {
                if (!$(this).attr('disabled')) {
                    Appery.navigateTo('mapPage', {
                        transition: 'slide',
                        reverse: false
                    });

                }
            },
        });

    }

    $("#profile").die("pagebeforeshow").live("pagebeforeshow", function(event, ui) {
        profile_beforeshow();
    });

    if (runBeforeShow) {
        profile_beforeshow();
    } else {
        profile_onLoad();
    }

}

$("#profile").die("pageinit").live("pageinit", function(event, ui) {
    Appery.processSelectMenu($(this));
    profile_js();
});