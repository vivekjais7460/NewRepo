package com.tweet.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import com.tweet.model.User;

public class TweetMain {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		TweetInterface tb=new TweetService();
		while(true){
			System.out.println();
			System.out.println("   *****--Welcome to Tweet App--*****   ");
			System.out.println("-----------------------------------");
			System.out.println("Press 1 For Login");
			System.out.println("Press 2-If You Are New User");
			System.out.println("Press 3 if you have Forrgotten your password");
			System.out.println("Enter your choice");
			int choice=Integer.parseInt(br.readLine());
			switch(choice) {
			case 1://Login
				System.out.println("Login Menu");
				System.out.println("-------------");
				System.out.println("Enter Your Email: ");
				String email1=br.readLine();
				System.out.println("Enter your password:");
				String password1=br.readLine();
				Boolean b=tb.validate(email1, password1);
				if(b==true) {
				boolean a=true;
				while(a) {
					System.out.println("Press 1 for Post a Tweet");
					System.out.println("Press 2 for View All your Tweets");
					System.out.println("Press 3 for View All User's Tweets");
					System.out.println("Press 4 for View All Users");
					System.out.println("Press 5 for Reset Password");
					System.out.println("Press 6 for Logout from TweetApp");
					System.out.println("--------------------------------");
					System.out.println("Enter Choice");
					int ch=Integer.parseInt(br.readLine());
					
					switch(ch) {
					case 1://Post Tweet.
						System.out.println("Whats on your Mind Please Type here:");
						String ltweet=br.readLine();
						tb.postTweet(ltweet,email1);
						break;
					case 2://View User's Tweet.
						System.out.println("View All Your Tweets");
						tb.viewMyTweet(email1);
						break;
					case 3://View all Tweets of different Users
						System.out.println("View All Users Tweet");
						tb.viewAllTweets();
						break;
					case 4://View All Users
						tb.viewAllUsers();
						break;
					case 5://Password Reset
						System.out.println("Enter your New Password:");
						String ps=br.readLine();
						 tb.resetPassword(email1, ps);
						break;
					case 6://User Logout
						tb.logout(email1);
						a=false;
						break;
					default:
						 System.out.println("Please select proper Options");
						 break;
					}
				}
				}
				else
					System.out.println("Invalid Password or Email");
				break;
			case 2://New User Registration
				System.out.println("Registration of New User");
				System.out.println("Enter Your Name: ");
				String name=br.readLine();
				System.out.println("Enter Your Email: ");
				String email=br.readLine();
				System.out.println("Create your password:");
				String password=br.readLine();
				System.out.println("Enter Your DOB in DD/MM/YYYY format: ");
				String dob=br.readLine();
				System.out.println();
				User user=new User(name,email,password,dob);
				tb.register(user);
				break;
			case 3://Forgot password
				System.out.println("Password");
				System.out.println("Enter Your Email: ");
				String email11=br.readLine();
				System.out.println("Enter Your DOB in DD/MM/YYYY format: ");
				String dob1=br.readLine();
				String s1=tb.forgetPass(email11, dob1);
				System.out.println("Your Password is "+s1+" .Please reset your Password after login.");
				break;
			 default:
				 System.out.println("Please select proper Options");
				 break;
		
			}
			
		}
	
	}

}
