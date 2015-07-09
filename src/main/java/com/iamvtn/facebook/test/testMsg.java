package com.iamvtn.facebook.test;

import java.util.List;

import com.iamvtn.facebook.api.GetMessage;
import com.iamvtn.facebook.model.FBMessage;
import com.iamvtn.facebook.model.FBMessages;
import com.iamvtn.facebook.model.FBMsgCommentData;
import com.iamvtn.facebook.model.FBMsgCommentPaging;
import com.iamvtn.facebook.model.FBMsgComments;
import com.restfb.types.NamedFacebookType;

public class testMsg {
	static GetMessage myInbox = new GetMessage();

	public static void main(String[] args) {
		getMessageWithPram("282531071907729", "enc_AdDIqNnbAzvBwunWZC8zfikflO6QytiZBFz9dArNflSDoWkxyibZAn4WcEuT44usEBmqdeL673x1ntx14CMVJLNvjex",
				"1435509101", "25", true);
		getOneMessage("282531071907729");
		getInbox();
	}

	public static void getMessageWithPram(String id, String paging_token, String sinceOrUntil,
			String limit, boolean next) {
		FBMsgComments fbMsgComments = myInbox.getComments(id, paging_token, sinceOrUntil, limit, next);
		List<FBMsgCommentData> msgComments = fbMsgComments.getData();
		FBMsgCommentPaging fbMsgCommentPaging = fbMsgComments.getPaging();
		for (FBMsgCommentData msgComment : msgComments) {
			showComment(msgComment);
		}
		System.out.println("Next Page: " + fbMsgCommentPaging.getNext());
		System.out.println("Previous Page: " + fbMsgCommentPaging.getPrevious());
	}

	public static void getOneMessage(String id) {
		FBMsgComments fbMsgComments = myInbox.getComments(id);
		List<FBMsgCommentData> msgComments = fbMsgComments.getData();
		FBMsgCommentPaging fbMsgCommentPaging = fbMsgComments.getPaging();
		for (FBMsgCommentData msgComment : msgComments) {
			showComment(msgComment);
		}
		System.out.println("Next Page: " + fbMsgCommentPaging.getNext());
		System.out.println("Previous Page: " + fbMsgCommentPaging.getPrevious());
	}

	public static void getInbox() {
		FBMessages fbMessages = myInbox.getInbox();
		List<FBMessage> listMessage = fbMessages.getListFBMessage();
		for (FBMessage message : listMessage) {
			showMessages(message);
		}

		System.out.println("Next Page: " + fbMessages.getNext());
		System.out.println("previous Page: " + fbMessages.getPrevious());
	}

	public static void showMessages(FBMessage message) {
		System.out.println("Message ID: " + message.getId());
		System.out.println("Member: ");
		for (NamedFacebookType name : message.getTo()) {
			System.out.print(", Name : " + name.getName());
			System.out.print(" - ID : " + name.getId());
		}
		System.out.println("\n Messages: ");
		for (FBMsgCommentData comments : message.getComments().getData()) {
			showComment(comments);
		}
	}

	public static void showComment(FBMsgCommentData comments) {
		String name = "Anonymous";
		if (comments.getFrom() != null && comments.getFrom().getName() != null) {
			name = comments.getFrom().getName();
		}
		String messageStr = "Sticker!";
		if (comments.getMessage() != null) {
			messageStr = comments.getMessage();
		}
		System.out.println(name + ": " + messageStr);
	}
}
