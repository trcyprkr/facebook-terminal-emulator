window.fbAsyncInit = function() {
	FB.init({
		appId : fbAppId,
		channelUrl : fbChannelUrl,
		xfbml : true,
		version : 'v2.3'
	});
};

(function(d, s, id) {
	var js, fjs = d.getElementsByTagName(s)[0];
	if (d.getElementById(id)) {
		return;
	}
	js = d.createElement(s);
	js.id = id;
	js.src = "lib/sdk.js";
	fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));
