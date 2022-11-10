package com.tweet;

import com.tweet.model.User;
import com.tweet.service.TweetInterface;
import com.tweet.service.TweetService;

public class ApplicationMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*User us=new User("deepak","deepak2@gmail.com","start@7646","22-22-2022",1);
		TweetInterface s=new TweetService();
		s.register(us);*/
		TweetInterface s=new TweetService();
		Boolean s1= s.validate("vivek@gmail.com","vivek123");
		System.out.println(s1);
		
		

	}

}
