var fb_access_token;

var introduce = "Facebook Terminal Emulator\n";
introduce = introduce + "A command line interface (CLI) for facebook.\n";
introduce = introduce + "If you wanna help, simply type 'help'.\n"
introduce = introduce + "For more details, check here https://github.com/batnam/facebook-api\n";

var help = '\tType login first to get your permission\n';
help = help + '\tType inbox to see your inbox\n';
help = help + '\tType thread|[id] to see your message detail\n'
help = help + '\tType newfeed to see your newfeed\n';
help = help + '\tType clear if you want clear your messages\n';

var next;
var previous;

var fbAppId = '178633945603433';
var fbAppSecret = 'ca9620447a10f406634665a6d9856da7';
var fbChannelUrl = 'http://iamvtn.com/facebook-api/html/';

var extendAccessTokenURL = 'https://graph.facebook.com/oauth/access_token?client_id='+fbAppId+'&client_secret='+fbAppSecret+'&grant_type=fb_exchange_token'+'&fb_exchange_token=';