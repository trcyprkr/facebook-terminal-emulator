package com.iamvtn.facebook.model;

import com.restfb.Facebook;
import com.restfb.types.FacebookType;

public class FBMsgCommentDataFrom extends FacebookType {
	private static final long serialVersionUID = 4782049735124805733L;

	@Facebook
	String name;

	@Facebook
	String id;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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

}
