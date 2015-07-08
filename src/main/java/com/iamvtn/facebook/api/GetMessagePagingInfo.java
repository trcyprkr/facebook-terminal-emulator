package com.iamvtn.facebook.api;

import com.iamvtn.facebook.model.FBMsgCommentPaging;
import com.iamvtn.facebook.model.FBPagingInfo;

public class GetMessagePagingInfo {
	private static volatile GetMessagePagingInfo instance;

	public static GetMessagePagingInfo getInstance() {
		if (instance == null) {
			synchronized (GetMessagePagingInfo.class) {
				if (instance == null) {
					instance = new GetMessagePagingInfo();
				}
			}
		}
		return instance;
	}

	static String LIMIT = "limit=";
	static String API_VERSION = "https://graph.facebook.com/v2.0/";
	static String PAGING_TOKEN = "__paging_token=";
	static String UNTIL = "until=";
	static String SINCE = "since=";
	static String ACCESS_TOKEN = "access_token=";
	static String EMPTY = "";
	static String API_VERSION_TAIL = "/inbox?format=json";

	String id;
	String pagingToken;
	String until;
	String limit;
	String accessToken;
	String since;

	public FBPagingInfo getPagingInfo(FBMsgCommentPaging commentPaging) {
		FBPagingInfo fbPaging = new FBPagingInfo();

		String next = commentPaging.getNext();
		splitURL(next);
		fbPaging.setAccessToken(accessToken);
		fbPaging.setNextID(id);
		fbPaging.setNextPagingToken(pagingToken);
		fbPaging.setNextUntil(until);
		fbPaging.setNextLimit(limit);

		String previous = commentPaging.getPrevious();
		splitURL(previous);
		fbPaging.setPreviousID(id);
		fbPaging.setPreviousPagingToken(pagingToken);
		fbPaging.setPreviousSince(since);
		fbPaging.setPreviousLimit(limit);

		return fbPaging;
	}

	public void splitURL(String url) {
		String[] split = url.split("&");
		for (String str : split) {
			if (str.startsWith(LIMIT)) {
				str = str.replaceAll(LIMIT, EMPTY);
				limit = str;
			} else if (str.startsWith(UNTIL)) {
				str = str.replaceAll(UNTIL, EMPTY);
				until = str;
			} else if (str.startsWith(PAGING_TOKEN)) {
				str = str.replaceAll(PAGING_TOKEN, EMPTY);
				pagingToken = str;
			} else if (str.startsWith(API_VERSION)) {
				str = str.replaceAll(API_VERSION, EMPTY);
				String[] temp = str.split("/");
				id = temp[0];
			} else if (str.startsWith(ACCESS_TOKEN)) {
				str = str.replaceAll(ACCESS_TOKEN, EMPTY);
				accessToken = str;
			} else if (str.startsWith(SINCE)) {
				str = str.replaceAll(SINCE, EMPTY);
				since = str;
			}
		}
	}

}
