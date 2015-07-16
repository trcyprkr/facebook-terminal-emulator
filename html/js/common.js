function errorLogs(term, response) {
	console.log(response.error);
	term.echo('Error !!! ' );
	term.echo('Error code: ' + response.error.code);
	term.echo('Error message: ' + response.error.message);
	term.echo('Error type: ' + response.error.type);
};

function httpGet(theUrl) {
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.open( "GET", theUrl, false );
    xmlHttp.send( null );
    return xmlHttp.responseText;
}