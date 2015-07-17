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
			var status_type = response.data[i].status_type;
			var story_tags = response.data[i].story_tags;
			
			var check = false;			

			if (story_tags == null) {
				console.log(story_tags);
				if (name != null && name != '' && message != null && message != '') {
					term.echo('\n=======================================================================================\n');
					term.echo(name + ':', {
						finalize: function(div) {
							div.css("color", "#009F6B");
						}
					});
					check = true;
					term.echo(new String(message));	
				} 
				
				if (status_type == 'shared_story' && description != null && description != '' && check == true) {
					term.echo(new String(description));	
				}
				if (picture != null && picture != '' && check == true) {
					term.echo("<br /><img src='" + picture + "'><br />", {raw: true})
				}
				if (link != null && link!= '' && check == true) {
					term.echo('Link: ' + link);
				} 
			}
		}
		nextFeed = cutNextURL(response.paging.next);
		previousFeed = cutNextURL(response.paging.previous);
	}
	else {
		errorLogs(term, response);
	}
}