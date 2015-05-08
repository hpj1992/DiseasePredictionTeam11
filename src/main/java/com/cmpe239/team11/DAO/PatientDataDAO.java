package com.cmpe239.team11.DAO;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.cmpe239.team11.Model.DNA;
import com.cmpe239.team11.Model.PatientData;
import com.cmpe239.team11.Utility.MongoConfig;

public class PatientDataDAO {
	public static void addPatientData(PatientData patient){
		MongoConfig.getMongoOperationsObj().save(patient);
	}
	
	public static PatientData getPatientData(String email){
		Query query=new Query();
		query.addCriteria(Criteria.where("email").in(email));
		PatientData patientGot=(PatientData)MongoConfig.getMongoOperationsObj().find(query, PatientData.class);
		return patientGot;
	}
	
	public static void updatePatientData(PatientData patientData){
		Query query=new Query();
		query.addCriteria(Criteria.where("email").in(patientData.getEmail()));
		Update update=new Update();
		update.set("age", patientData.getAge());
		update.set("dna", patientData.getDNA());
		update.set("menopause", patientData.getMenopause());
		update.set("bmi", patientData.getBMI());
		update.set("ageMenarche", patientData.getAgeMenarche());
		update.set("race", patientData.getRace());
		MongoConfig.getMongoOperationsObj().findAndModify(query, update, PatientData.class);
	
	}
}
