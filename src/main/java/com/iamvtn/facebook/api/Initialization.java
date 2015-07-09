package com.iamvtn.facebook.api;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;

public class Initialization {
	private final static String MY_ACCESS_TOKEN = "";

	FacebookClient facebookClient;
	private static volatile Initialization instance;

	@SuppressWarnings("deprecation")
	private Initialization() {
		facebookClient = new DefaultFacebookClient(MY_ACCESS_TOKEN);
	}

	public static Initialization getInstance() {
		if (instance == null) {
			synchronized (Initialization.class) {
				if (instance == null) {
					instance = new Initialization();
				}
			}
		}
		return instance;
	}

	public FacebookClient getFacebookClient() {
		return this.facebookClient;
	}
}
