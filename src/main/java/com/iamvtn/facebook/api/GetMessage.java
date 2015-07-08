package com.iamvtn.facebook.api;

import java.util.List;

import com.iamvtn.facebook.model.FBMessage;
import com.iamvtn.facebook.model.FBMessages;
import com.iamvtn.facebook.model.FBMsgCommentData;
import com.iamvtn.facebook.model.FBMsgCommentPaging;
import com.iamvtn.facebook.model.FBMsgComments;
import com.iamvtn.facebook.model.FBPagingInfo;
import com.restfb.Connection;
import com.restfb.FacebookClient;
import com.restfb.Parameter;

public class GetMessage {
	FacebookClient facebookClient = Initialization.getInstance().getFacebookClient();

	public FBMessages getInbox() {
		Connection<FBMessage> filteredMessage = facebookClient.fetchConnection("me/inbox", FBMessage.class);
		List<FBMessage> listMessage = filteredMessage.getData();
		FBMessages fbMessages = new FBMessages();
		fbMessages.setListFBMessage(listMessage);

		FBMsgCommentPaging commentPaging = new FBMsgCommentPaging();
		commentPaging.setNext(filteredMessage.getNextPageUrl());
		commentPaging.setPrevious(filteredMessage.getPreviousPageUrl());

		fbMessages.setNext(filteredMessage.getNextPageUrl());
		fbMessages.setPrevious(filteredMessage.getPreviousPageUrl());

		FBPagingInfo fbPagingInfo = new FBPagingInfo();
		fbPagingInfo = GetMessagePagingInfo.getInstance().getPagingInfo(commentPaging);
		fbMessages.setFbPagingInfo(fbPagingInfo);

		return fbMessages;
	}

	public FBMsgComments getComments(String id, String paging_token, String sinceOrUntil, String limit, boolean next) {
		Connection<FBMsgCommentData> filteredMessage;
		if (next == true) {
			filteredMessage = facebookClient.fetchConnection(id + "/comments", FBMsgCommentData.class,
					Parameter.with("__paging_token", paging_token), Parameter.with("until", sinceOrUntil),
					Parameter.with("limit", limit));
		} else {
			filteredMessage = facebookClient.fetchConnection(id + "/comments", FBMsgCommentData.class,
					Parameter.with("__paging_token", paging_token), Parameter.with("since", sinceOrUntil),
					Parameter.with("limit", limit), Parameter.with("__previous", 1));
		}
		List<FBMsgCommentData> listMessage = filteredMessage.getData();

		FBMsgCommentPaging fbMsgCommentPaging = new FBMsgCommentPaging();
		fbMsgCommentPaging.setNext(filteredMessage.getNextPageUrl());
		fbMsgCommentPaging.setPrevious(filteredMessage.getPreviousPageUrl());

		FBMsgComments fbMsgComments = new FBMsgComments();
		fbMsgComments.setData(listMessage);
		fbMsgComments.setPaging(fbMsgCommentPaging);

		return fbMsgComments;
	}

	public FBMsgComments getComments(String id) {
		Connection<FBMsgCommentData> filteredMessage = facebookClient.fetchConnection(id + "/comments", FBMsgCommentData.class);
		List<FBMsgCommentData> listMessage = filteredMessage.getData();

		FBMsgCommentPaging fbMsgCommentPaging = new FBMsgCommentPaging();
		fbMsgCommentPaging.setNext(filteredMessage.getNextPageUrl());
		fbMsgCommentPaging.setPrevious(filteredMessage.getPreviousPageUrl());

		FBMsgComments fbMsgComments = new FBMsgComments();
		fbMsgComments.setData(listMessage);
		fbMsgComments.setPaging(fbMsgCommentPaging);

		return fbMsgComments;
	}
}
