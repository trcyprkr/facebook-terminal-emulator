function meInbox(term, limit) {
	var uriInbox = "/me/inbox?limit=" + limit;
	
	FB.api(uriInbox, {
		access_token : fb_access_token,
	}, function(response) {
		if (response && !response.error) {
			console.log(response.data);
			for (var i = 0; i < response.data.length; i++) {
				var thread = response.data[i];
				var name = 'ID: ' + thread.id + ' Memember: ';
				for (var j = 0; j < thread.to.data.length; j++) {
					var to = thread.to.data[j];
					name = name + to.name + '|';
				}
				term.echo(name);
			}
			term.echo('\n');
		} else {
			console.log(response.error);
		}
	});
}

function threadMessage(apiURI, term) {
	console.log(apiURI);
	FB.api(apiURI, {
		access_token : fb_access_token,
	}, function(response) {
		if (response && !response.error) {
			console.log(response);
			var thread = response.comments.data;	
			var paging = response.comments.paging;	
			for (var k = 0; k < thread.length; k++) {
				var comment = thread[k];
				var name =  comment.from.name;
				var message = comment.message;
				if (message == null) {
					message = 'Sticker!';
				}
				var conversation = name +' : ' +message;
				term.echo(conversation);
			}
			term.echo('\n');
			next = cutNextComment(paging.next);
			previous = cutNextComment(paging.previous);
			console.log(next);
			console.log(previous);
		} else {
			console.log(response.error);
		}
	});
}

function nextThreadMessage(apiURI, term) {
	console.log(apiURI);
	FB.api(apiURI, {
	}, function(response) {
		if (response && !response.error) {
			console.log(response);
			var thread = response.data;	
			var paging = response.paging;	
			for (var k = 0; k < thread.length; k++) {
				var comment = thread[k];
				var name =  comment.from.name;
				var message = comment.message;
				if (message == null) {
					message = 'Sticker!';
				}
				var conversation = name +' : ' +message;
				term.echo(conversation);
			}
			term.echo('\n');
			next = cutNextComment(paging.next);
			previous = cutNextComment(paging.previous);
			console.log(next);
			console.log(previous);
		} else {
			console.log(response.error);
		}
	});
}

function cutNextComment(url) {
	var uri = url.substring(32);
	return uri;
}
