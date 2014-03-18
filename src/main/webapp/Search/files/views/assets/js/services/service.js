/*
 * Service settings
 */
var TwitterSearchSettings = {
    "consumerKey": "jar9cFNW2fm7brPtLZtNaA",
    "consumerKeySecret": "8CpTnDRLP0pfcHFbrFaBeaCWom29EJviAlxsUzfJTw"
}

/*
 * Services
 */

var TwitterSearch_SearchService = new Appery.RestService({
    'url': 'https://api.appery.io/rest/1/proxy/tunnel',
    'dataType': 'json',
    'type': 'get',
});

var KCActivitiesSearchService = new Appery.RestService({
    'url': 'http://kids-connect-rtmuv2dzja.elasticbeanstalk.com/api/activities?&q={search-query}&book={search-book}&dist={search-dist}&free={search-free}&activity={search-activity}&agerange={search-agerange}',
    'dataType': 'json',
    'type': 'get',
});

var TwitterRESTAuthService = new Appery.RestService({
    'url': 'https://api.appery.io/rest/1/proxy/tunnel',
    'dataType': 'json',
    'type': 'post',
    'contentType': 'application/x-www-form-urlencoded',

    'serviceSettings': TwitterSearchSettings
});