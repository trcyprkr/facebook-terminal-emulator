var fb_access_token;

var introduce = "Facebook Terminal Emulator\n";
introduce = introduce + "A command line interface (CLI) for facebook.\n";
introduce = introduce + "Type 'login' to start";
introduce = introduce + "If you wanna help, simply type 'help'.\n"
introduce = introduce + "For more details, check here https://github.com/batnam/facebook-api\n";

var help = "\tType 'login' first to get your permission\n";
help = help + "\tType 'inbox' to see your messages and type 'next msg' or 'previous msg' to read more messages\n";
help = help + "\tType 'thread#[MESSAGE_ID]' to see your message detail, type 'next msg' or 'previous msg' to read more messages\n"
help = help + "\tType home to see your new feed and type 'next feed' or 'previous feed' read more feeds\n";
help = help + "\tType 'clear' if you wanna clear your terminal\n";

var commandNotFound = "";

var next;
var previous;

var previousFeed;
var nextFeed;
var pageFeed = 0;

var nextNotiy;
var previousNotify;

var fbAppId = '178633945603433';
var fbAppSecret = 'ca9620447a10f406634665a6d9856da7';
var fbChannelUrl = 'http://iamvtn.com/facebook-api/html/';

var extendAccessTokenURL = 'https://graph.facebook.com/oauth/access_token?client_id='+fbAppId+'&client_secret='+fbAppSecret+'&grant_type=fb_exchange_token'+'&fb_exchange_token=';