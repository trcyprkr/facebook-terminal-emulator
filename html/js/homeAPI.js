function meHome(term) {
	var uriHome = "/me/home";
	var result = true;
	FB.api(uriHome, {
		access_token : fb_access_token,
	}, function(response) {
		if (response && !response.error) {
			showNewFeed(response, term);
			pageFeed = 1;
		} else {
			errorLogs(term, response);
			result = false;
		}
	});
	return result;
}

function showNextFeed(term, nextFeed) {
	var result = true;
	FB.api(nextFeed, {
	
	}, function(response) {
		if (response && !response.error) {
			console.log(response);
			showNewFeed(response, term);
		} else {
			errorLogs(term, response);
			result = false;
		}
	});
	return result;
}


function showNewFeed(response, term) {
	if (response && !response.error) {
		term.echo('Your new feed: ');
		for (var i = 0; i < response.data.length; i++) {
			var name = response.data[i].from.name;
			var link = response.data[i].link;
			var message = response.data[i].message;
			var picture = response.data[i].picture;
			var story = response.data[i].story;
			var description = response.data[i].description;
			
			var check = false;			
			if (name != null && name != '' && message != null && message != '') {
				term.echo(name + ' : ' + message);	
				check = true;	
			} 
			if (picture != null && picture != '') {
				term.echo('Image: ' + picture);
			} 
			if (check == true) {
				term.echo('\n========================================================================================\n');
			}
		}
		nextFeed = cutNextURL(response.paging.next);
		previousFeed = cutNextURL(response.paging.previous);
		console.log(nextFeed);
		console.log(previousFeed);
		console.log(response);
	}
	else {
		errorLogs(term, response);
	}
}