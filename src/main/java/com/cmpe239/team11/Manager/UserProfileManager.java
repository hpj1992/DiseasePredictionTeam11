package com.cmpe239.team11.Manager;

import com.cmpe239.team11.DAO.UserProfileDAO;
import com.cmpe239.team11.Model.UserProfile;

public class UserProfileManager {

	public static void AddUserProfile(UserProfile user){
		UserProfileDAO.AddNewUser(user);
	}
}
