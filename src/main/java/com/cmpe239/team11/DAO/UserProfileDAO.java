package com.cmpe239.team11.DAO;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

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
	
	public static boolean isExistingUser(UserProfile user){
		Query query=new Query();
		query.addCriteria(Criteria.where("email").in(user.getEmail()));
		UserProfile userProfile=(UserProfile) MongoConfig.getMongoOperationsObj().find(query, UserProfile.class);
		if(userProfile==null)
			return false;
		else
			return true;
		
	}
}
