package com.iamvtn.facebook.model;

public class FBPagingInfo {
	String previousID;
	String previousPagingToken;
	String previousSince;
	String previousLimit;

	String nextID;
	String nextPagingToken;
	String nextUntil;
	String nextLimit;

	String accessToken;

	/**
	 * @return the accessToken
	 */
	public String getAccessToken() {
		return accessToken;
	}

	/**
	 * @param accessToken the accessToken to set
	 */
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	/**
	 * @return the previousID
	 */
	public String getPreviousID() {
		return previousID;
	}

	/**
	 * @param previousID the previousID to set
	 */
	public void setPreviousID(String previousID) {
		this.previousID = previousID;
	}

	/**
	 * @return the previousPagingToken
	 */
	public String getPreviousPagingToken() {
		return previousPagingToken;
	}

	/**
	 * @param previousPagingToken the previousPagingToken to set
	 */
	public void setPreviousPagingToken(String previousPagingToken) {
		this.previousPagingToken = previousPagingToken;
	}

	/**
	 * @return the previousSince
	 */
	public String getPreviousSince() {
		return previousSince;
	}

	/**
	 * @param previousSince the previousSince to set
	 */
	public void setPreviousSince(String previousSince) {
		this.previousSince = previousSince;
	}

	/**
	 * @return the previousLimit
	 */
	public String getPreviousLimit() {
		return previousLimit;
	}

	/**
	 * @param previousLimit the previousLimit to set
	 */
	public void setPreviousLimit(String previousLimit) {
		this.previousLimit = previousLimit;
	}

	/**
	 * @return the nextID
	 */
	public String getNextID() {
		return nextID;
	}

	/**
	 * @param nextID the nextID to set
	 */
	public void setNextID(String nextID) {
		this.nextID = nextID;
	}

	/**
	 * @return the nextPagingToken
	 */
	public String getNextPagingToken() {
		return nextPagingToken;
	}

	/**
	 * @param nextPagingToken the nextPagingToken to set
	 */
	public void setNextPagingToken(String nextPagingToken) {
		this.nextPagingToken = nextPagingToken;
	}

	/**
	 * @return the nextUntil
	 */
	public String getNextUntil() {
		return nextUntil;
	}

	/**
	 * @param nextUntil the nextUntil to set
	 */
	public void setNextUntil(String nextUntil) {
		this.nextUntil = nextUntil;
	}

	/**
	 * @return the nextLimit
	 */
	public String getNextLimit() {
		return nextLimit;
	}

	/**
	 * @param nextLimit the nextLimit to set
	 */
	public void setNextLimit(String nextLimit) {
		this.nextLimit = nextLimit;
	}
}
