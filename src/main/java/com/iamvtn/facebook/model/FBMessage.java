package com.iamvtn.facebook.model;

import com.restfb.Facebook;
import com.restfb.types.Message;

public class FBMessage extends Message {
	private static final long serialVersionUID = 3351348464166445902L;

	@Facebook
	private FBMsgComments comments;

	/**
	 * @return the comments
	 */
	public FBMsgComments getComments() {
		return comments;
	}

	/**
	 * @param comments the comments to set
	 */
	public void setComments(FBMsgComments comments) {
		this.comments = comments;
	}
}
