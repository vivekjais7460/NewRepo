package com.tweet.service;

import com.tweet.model.User;

public interface TweetInterface {
	 public void register(User user);
	 public void viewAllTweets();
	 public String forgetPass(String email,String dob);
	 public void viewMyTweet(String useremail);
	 public void postTweet(String useremail,String tweet);
	 public void resetPassword(String useremail,String newpassword);
	 public void logout(String useremail);
	 public void viewAllUsers();
	 public boolean validate(String useremail,String password);
  

}
