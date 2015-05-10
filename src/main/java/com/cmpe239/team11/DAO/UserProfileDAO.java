package com.cmpe239.team11.DAO;

import java.util.ArrayList;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.cmpe239.team11.Model.UserProfile;
import com.cmpe239.team11.Utility.MongoConfig;

public class UserProfileDAO {

	public static void AddNewUser(UserProfile user){
		
		MongoConfig.getMongoOperationsObj().save(user);
	}
	
	public static void RemoveUser(UserProfile user){
		MongoConfig.getMongoOperationsObj().remove(user);
	}
	
	public static UserProfile GetAuthenticatedUser(String email,String password){
		Query query=new Query();
		query.addCriteria(Criteria.where("email").in(email));
		query.addCriteria(Criteria.where("password").in(password));
		
		UserProfile user=(UserProfile)MongoConfig.getMongoOperationsObj().findOne(query, UserProfile.class);
		return user;
	}
	
	public static boolean isExistingUser(String email){
		Query query=new Query();
		query.addCriteria(Criteria.where("email").in(email));
		ArrayList<UserProfile> userProfileList=(ArrayList<UserProfile>) MongoConfig.getMongoOperationsObj().find(query, UserProfile.class);
		if(userProfileList.size()>0)
			return true;
		else
			return false;
		
	}
	
	public static void updateuserProfile(UserProfile user){
		Query query=new Query();
		query.addCriteria(Criteria.where("email").in(user.getEmail()));
		
		Update update=new Update();
		update.set("firstName", user.getFirstName());
		update.set("lastName", user.getLastname());
		update.set("birthDate", user.getBirthDate());
		
		MongoConfig.getMongoOperationsObj().findAndModify(query, update, UserProfile.class);
	}
}
