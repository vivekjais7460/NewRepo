package com.tweet.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;

import com.tweet.model.User;




public class TweetService implements TweetInterface {
	Connection con;
	
	
	  @Override
	    public void register(User user) {
	       con =DBConnection.createDBConnetion();
	       String query="INSERT INTO users (firstname, email, password,dob,online) VALUES (?,?,?,?,?);";
	       try{
	           PreparedStatement pstm=con.prepareStatement(query);
	           pstm.setString(1,user.getFirstname());
	           pstm.setString(2,user.getEmail());
	           pstm.setString(3,user.getPassword());
	           pstm.setString(4,user.getDob());
	           pstm.setInt(5,user.getOnline());
	          int cnt= pstm.executeUpdate();
	          if(cnt!=0)
	              System.out.println("Your Registration is successful: Please enter 1 for Login into TweetApp");
	          else 
	        	  System.out.println("Your Email id is already in user,Please provide the new email ID");
	          }
	       catch (Exception ex){
	           ex.printStackTrace();
	       }

	    }
	
	@Override
	public void viewAllTweets() {
		con=DBConnection.createDBConnetion();
        String query="SELECT tweet,useremail,tweetdatetime FROM tweets;";
        System.out.println("All the Tweets of the Users");
        System.out.println("---------------------------------------------");

        System.out.format("%s\t%s\t%s\n","Tweets","useremail","Date&Time");
        System.out.println("---------------------------------------------");

        try{
            Statement stmt=con.createStatement();
            ResultSet result= stmt.executeQuery(query);
            while (result.next()){
                System.out.format("%s\t%s\t%s\n",
                        result.getString(1),
                        result.getString(2),
                        result.getString(3));
                System.out.println("---------------------------------------------");

            }

        }catch (Exception ex){
            ex.printStackTrace();
        }

    }
	
	@Override
	public String forgetPass(String email, String dob) {
		con=DBConnection.createDBConnetion();
        String query="SELECT password FROM users WHERE email='"+email+"' AND "+"dob='"+dob+"';";
        String s = null;
        try{
        	Statement stmt=con.createStatement();
            ResultSet result= stmt.executeQuery(query);
            result.next();
            s=result.getString(1);
        }

         catch (Exception ex){
            ex.printStackTrace();
        }
        return s;
	}
	
	@Override
	public void viewMyTweet(String useremail) {
		con=DBConnection.createDBConnetion();
        String query="SELECT tweet,tweetdatetime FROM tweets WHERE useremail='"+useremail+"';";
        System.out.println("Here are Your Tweeets");
        System.out.println("---------------------------------------------");

        System.out.format("%s\t%s\t\n","Tweets","Date&Time");
        System.out.println("---------------------------------------------");

        try{
            Statement stmt=con.createStatement();
            ResultSet result= stmt.executeQuery(query);
            while (result.next()){
                System.out.format("%s\t%s\t\n",
                        result.getString(1),
                        result.getString(2));
                System.out.println("---------------------------------------------");

            }

        }catch (Exception ex){
            ex.printStackTrace();
        }
		
		
	}

	@Override
	public void postTweet(String tweet,String useremail) {
		  con =DBConnection.createDBConnetion();
		  
	       String query="INSERT INTO tweets(tweet, useremail,tweetdatetime) VALUES (?,?,?);";
	       try{
	           PreparedStatement pstm=con.prepareStatement(query);
	           pstm.setString(1,tweet);
	           pstm.setString(2,useremail);
	           LocalDateTime dt=LocalDateTime.now();
	           String dtm=dt.toString();
	           pstm.setString(3,dtm);
	          int cnt= pstm.executeUpdate();
	          if(cnt!=0)
	              System.out.println("You have Tweeted this Just now:"+tweet);
	          }
	       catch (Exception ex){
	           ex.printStackTrace();
	       }
		
	}

	@Override
	public void resetPassword(String useremail, String newpassword) {
		// TODO Auto-generated method stub
		con=DBConnection.createDBConnetion();
        String query="UPDATE users SET password='"+newpassword+"' WHERE email='"+useremail+"';";
        try{
            PreparedStatement pstm=con.prepareStatement(query);
            int cnt=pstm.executeUpdate();
            if(cnt!=0)
                System.out.println("Your Password has been reset successfully");

        }catch (Exception ex){
            ex.printStackTrace();
        }
		
	}

	@Override
	public void logout(String useremail) {
		// TODO Auto-generated method stub
		con=DBConnection.createDBConnetion();
        String query="UPDATE users SET online=0 WHERE email='"+useremail+"';";
        try{
            PreparedStatement pstm=con.prepareStatement(query);
            int cnt=pstm.executeUpdate();
            if(cnt!=0)
                System.out.println("You Have SuccessFully Logged Out---BYE");

        }catch (Exception ex){
            ex.printStackTrace();
        }
		
	}

	@Override
	public void viewAllUsers() {
		// TODO Auto-generated method stub
		con=DBConnection.createDBConnetion();
        String query="SELECT firstname,email FROM users;";
        System.out.println("All the  Tweet App Users");
        System.out.println("---------------------------------------------");

        System.out.format("%s\t%s\t\n","Name","Useremail");
        System.out.println("------------------------------");

        try{
            Statement stmt=con.createStatement();
            ResultSet result= stmt.executeQuery(query);
            while (result.next()){
                System.out.format("%s\t%s\t\n",
                        result.getString(1),
                        result.getString(2));
                System.out.println("---------------------------------------------");

            }

        }catch (Exception ex){
            ex.printStackTrace();
        }
		
	}

	@Override
	public boolean validate(String useremail, String password) {
		// TODO Auto-generated method stub
		con=DBConnection.createDBConnetion();
        String query="SELECT password FROM users WHERE email='"+useremail+"';";
        String s = password;
        try{
        	Statement stmt=con.createStatement();
            ResultSet result= stmt.executeQuery(query);
            result.next();
            String s1=result.getString(1);
            System.out.println("Check point");
            if(s.equals(s1)) {
            	 String query1="UPDATE users SET online=1 WHERE email='"+useremail+"';";
                 try{
                     PreparedStatement pstm=con.prepareStatement(query1);
                     int cnt=pstm.executeUpdate();
                     if(cnt!=0)
                         System.out.println("You have logged into Tweet App");
                        return true;

                 }catch (Exception ex){
                     ex.printStackTrace();
                 }
        }
            else return false;
        }
         catch (Exception ex){
            ex.printStackTrace();
        }
		
		return false;
	}
}
