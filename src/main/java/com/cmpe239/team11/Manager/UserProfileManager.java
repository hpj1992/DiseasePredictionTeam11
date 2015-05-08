package com.cmpe239.team11.Manager;

import com.cmpe239.team11.DAO.UserProfileDAO;
import com.cmpe239.team11.Model.UserProfile;

public class UserProfileManager {

	public static boolean isExistingUser(String email) {
		// TODO Auto-generated method stub
		return UserProfileDAO.isExistingUser(email);
	}

	public static void AddNewUser(UserProfile user){
		
		UserProfileDAO.AddNewUser(user);
	}
	
	public static void RemoveUser(UserProfile user){
		UserProfileDAO.RemoveUser(user);
	}
	
	public static UserProfile GetAuthenticatedUser(String email,String password){
		return UserProfileDAO.GetAuthenticatedUser(email, password);
	}
	
	public static void updateuserProfile(UserProfile user){
		UserProfileDAO.updateuserProfile(user);
	}
}
