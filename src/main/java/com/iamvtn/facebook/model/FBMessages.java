package com.iamvtn.facebook.model;

import java.util.List;

public class FBMessages {
	List<FBMessage> listFBMessage;
	String previous;
	String next;
	FBPagingInfo fbPagingInfo;

	/**
	 * @return the fbPagingInfo
	 */
	public FBPagingInfo getFbPagingInfo() {
		return fbPagingInfo;
	}

	/**
	 * @param fbPagingInfo the fbPagingInfo to set
	 */
	public void setFbPagingInfo(FBPagingInfo fbPagingInfo) {
		this.fbPagingInfo = fbPagingInfo;
	}

	/**
	 * @return the listFBMessage
	 */
	public List<FBMessage> getListFBMessage() {
		return listFBMessage;
	}

	/**
	 * @param listFBMessage the listFBMessage to set
	 */
	public void setListFBMessage(List<FBMessage> listFBMessage) {
		this.listFBMessage = listFBMessage;
	}

	/**
	 * @return the previous
	 */
	public String getPrevious() {
		return previous;
	}

	/**
	 * @param previous the previous to set
	 */
	public void setPrevious(String previous) {
		this.previous = previous;
	}

	/**
	 * @return the next
	 */
	public String getNext() {
		return next;
	}

	/**
	 * @param next the next to set
	 */
	public void setNext(String next) {
		this.next = next;
	}
}
