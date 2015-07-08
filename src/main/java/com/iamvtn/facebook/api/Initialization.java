package com.iamvtn.facebook.api;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;

public class Initialization {
	private final static String MY_ACCESS_TOKEN = "CAACEdEose0cBADEJQ5mZCmwxW57YLvHueUfWjVlisISl7FlMn9A3x79a0sVo9VJXVZC1Vq3Hevit9Jv6OGBWjndgUEh1WDoUxy743kjcNshaOtCYqhjzDs83PUm2bJmVj5DfRMo3LcBj1UeYQnjoDdSarmSodPfuZBF8xiWWIJPwI7xtU1BaZAxx0eGYALOJN7JBBFXtksAtMhZBPFwWwfmYZBKO4cFosE34qnNM9poAZDZD";
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
