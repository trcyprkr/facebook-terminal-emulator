package com.iamvtn.facebook.model;

import com.restfb.Facebook;
import com.restfb.types.FacebookType;

public class FBMsgCommentPaging extends FacebookType {
	private static final long serialVersionUID = 1L;

	@Facebook
	private String previous;

	@Facebook
	private String next;

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
