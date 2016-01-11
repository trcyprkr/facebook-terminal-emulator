function getNotifications(term) {
	var uriInbox = "/me/notifications?include_read=true";
	
	FB.api(uriInbox, {
		access_token : fb_access_token,
	}, function(response) {
		if (response && !response.error) {
			console.log(response);
			for (var i = 0; i < response.data.length; i++) {
				var notifyObj = response.data[i]; 
				term.echo('\n=================================\n');
				term.echo(notifyObj.title);
				term.echo('\nCreate Time: ' + notifyObj.created_time); 
				term.echo('\nLink: ' + notifyObj.link);
				if (notifyObj.object != null) {
					term.echo('\nMessage: ' + notifyObj.object.message);
				} 
			}
			nextNotiy = cutNextURL(response.paging.next);
			previousNotify = cutNextURL(response.paging.previous);
		} else {
			errorLogs(term, response);
		}
	});
	
}

function getNextNotifications(term, uriInbox) {
	console.log(uriInbox);
	FB.api(uriInbox, {
	}, function(response) {
		if (response && !response.error) {
			console.log(response);
			for (var i = 0; i < response.data.length; i++) {
				var notifyObj = response.data[i]; 
				term.echo('\n=================================\n');
				term.echo(notifyObj.title);
				term.echo('\nCreate Time: ' + notifyObj.created_time); 
				term.echo('\nLink: ' + notifyObj.link);
				if (notifyObj.object != null) {
					term.echo('\nMessage: ' + notifyObj.object.message);
				} 
			}
			nextNotiy = cutNextURL(response.paging.next);
			previousNotify = cutNextURL(response.paging.previous);
		} else {
			errorLogs(term, response);
		}
	});
}