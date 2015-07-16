function meHome(term) {
	var uriHome = "/me/home";
	
	FB.api(uriHome, {
		access_token : fb_access_token,
	}, function(response) {
		if (response && !response.error) {
			for (var i = 0; i < response.data.length; i++) {
				var name = response.data[i].from.name;
				var link = response.data[i].link;
				var message = response.data[i].message;
				var picture = response.data[i].picture;
				var story = response.data[i].story;
				var description = response.data[i].description;
				
				if (message != null && message != '') {
					term.echo(name + ' : ' + message);
				} else {
					term.echo(story + ' : ' + name + ':' + description);
				}
				
				term.echo('========================================================================================\n');
			}
		}
		else {
			errorLogs(term, response);
		}
	});
}