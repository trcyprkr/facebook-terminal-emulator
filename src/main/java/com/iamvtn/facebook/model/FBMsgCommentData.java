package com.iamvtn.facebook.model;

import com.restfb.Facebook;
import com.restfb.types.FacebookType;

public class FBMsgCommentData extends FacebookType {
	private static final long serialVersionUID = 1L;
	@Facebook
	private FBMsgCommentDataFrom from;

	@Facebook
	private String id;

	@Facebook
	private String message;

	@Facebook("created_time")
	private String rawCreatedTime;

	/**
	 * @return the from
	 */
	public FBMsgCommentDataFrom getFrom() {
		return from;
	}

	/**
	 * @param from the from to set
	 */
	public void setFrom(FBMsgCommentDataFrom from) {
		this.from = from;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the rawCreatedTime
	 */
	public String getRawCreatedTime() {
		return rawCreatedTime;
	}

	/**
	 * @param rawCreatedTime the rawCreatedTime to set
	 */
	public void setRawCreatedTime(String rawCreatedTime) {
		this.rawCreatedTime = rawCreatedTime;
	}
}
