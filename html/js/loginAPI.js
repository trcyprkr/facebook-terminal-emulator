function fbLogin(term) {
    FB.login(function(response) {
       if (response.authResponse) {
			var fbAccessToken = response.authResponse.accessToken;
			extendToken(response.authResponse.accessToken);
			term.echo('You have logged in successfully');
        } else {
            console.log('User cancelled login or did not fully authorize.');
			term.echo('ERROR: User cancelled login or did not fully authorize.');
        }
    },{scope: 'read_mailbox, read_stream, user_birthday, user_religion_politics, user_relationships, user_relationship_details, user_hometown, user_location, user_likes, user_education_history, user_work_history, user_website, user_groups, user_managed_groups, user_events, user_photos, user_videos, user_friends, user_about_me, user_status, user_games_activity, user_tagged_places, user_posts, read_page_mailboxes, rsvp_event, email, ads_management, ads_read, read_insights, manage_notifications, manage_pages, publish_pages, publish_actions, read_custom_friendlists, user_actions.books, user_actions.music, user_actions.video, user_actions.news, user_actions.fitness, public_profile'});
}

function extendToken(fbAccessToken) {
	var theUrl = extendAccessTokenURL + fbAccessToken;
	var responseText = httpGet(theUrl);
	fb_access_token = cutAccessToken(responseText)
}

function cutAccessToken(responseText) {
	var accessTokenStr = '';
	var next = false;
	var begin = 1;
	for (var i = 0; i < responseText.length; i++) {
		var temp = responseText.charAt(i);
		if (temp == '=') {
			next = true;
		}
		if (temp == '&') {
			next = false;
			break;
		}
		if (next == true) {
			if (begin > 1) {
				accessTokenStr = accessTokenStr + temp;
			}
			begin = begin + 1;
		}
	}
	
	return accessTokenStr;
}