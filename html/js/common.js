function errorLogs(term, response) {
	console.log(response.error);
	term.error('Error !!! ' );
	term.error('Error code: ' + response.error.code);
	term.error('Error message: ' + response.error.message);
	term.error('Error type: ' + response.error.type);
	if (response.error.code == '2500') {
		term.error("*** Please login first (type 'login') ***");
	}
};

function httpGet(theUrl) {
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.open( "GET", theUrl, false );
    xmlHttp.send( null );
    return xmlHttp.responseText;
}

function cutNextURL(url) {
	return url.substring(32);
}