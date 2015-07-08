package com.iamvtn.facebook.model;

import java.util.List;

import com.restfb.Facebook;
import com.restfb.types.FacebookType;

public class FBMsgComments extends FacebookType {
	private static final long serialVersionUID = 607165684412789378L;

	@Facebook
	private List<FBMsgCommentData> data;

	@Facebook
	private FBMsgCommentPaging paging;

	/**
	 * @return the data
	 */
	public List<FBMsgCommentData> getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(List<FBMsgCommentData> data) {
		this.data = data;
	}

	/**
	 * @return the paging
	 */
	public FBMsgCommentPaging getPaging() {
		return paging;
	}

	/**
	 * @param paging the paging to set
	 */
	public void setPaging(FBMsgCommentPaging paging) {
		this.paging = paging;
	}
}
