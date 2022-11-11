package com.tweet.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.tweet.model.User;
import com.tweet.service.TweetService;

class TweetServiceTestCase {
	User user=new User("TestUser","Test@gmail.com","Testpassword","12/11/2000");
	TweetService tb=new TweetService();

	@Test
	@DisplayName("Adding User To Tweet App")
	void testregister(){
		tb.register(user);
	}
	@Test
	@DisplayName("View All the Twwets of the users")
	void testviewAllTweets(){
		tb.viewAllTweets();
	}
	@Test
	@DisplayName("Forgot Password")
	void testforgotPassword(){
		String a=tb.forgetPass(user.getEmail(),user.getDob());
		assertEquals("Testpassword", a);
	}
	@Test
	@DisplayName("View User's Tweet")
	void testviewMyTweets(){
		tb.viewMyTweet(user.getEmail());
	}
	@Test
	@DisplayName("View all Users")
	void testviewAllusers(){
		tb.viewAllUsers();
	}
	@Test
	@DisplayName("Reset Password")
	void testresetPassword(){
		tb.resetPassword(user.getEmail(), "newpassword");
	}
	@Test
	@DisplayName("Post Tweets")
	void testPostTweet(){
		tb.postTweet("Tester is Tweeting",user.getEmail());
	}
	@Test
	@DisplayName("Validate")
	void testValidate(){
		boolean ab=tb.validate(user.getEmail(),"newpassword");
		assertEquals(true, ab);
	}
	@Test
	@DisplayName("Logout")
	void testLogout(){
		tb.logout(user.getEmail());
	}
	
	

}
