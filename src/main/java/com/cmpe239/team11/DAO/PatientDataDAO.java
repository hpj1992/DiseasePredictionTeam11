package com.cmpe239.team11.DAO;

import java.util.ArrayList;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.cmpe239.team11.Model.PatientData;
import com.cmpe239.team11.Utility.MongoConfig;

public class PatientDataDAO {
	public static ArrayList<String> rootFactors=new ArrayList<String>();
	public static double percent=0.0;
	
	public static void addPatientData(PatientData patient){
		MongoConfig.getMongoOperationsObj().save(patient);
	}
	
	public static PatientData getPatientData(String email){
		Query query=new Query();
		query.addCriteria(Criteria.where("email").in(email));
		PatientData patientGot=(PatientData)MongoConfig.getMongoOperationsObj().findOne(query, PatientData.class);
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
	
	public static boolean processPatientData(PatientData patient) {
		rootFactors.clear();

		if (Integer.valueOf(patient.getAge()) >=4) {
			rootFactors.add("Age");
			if (Integer.valueOf(patient.getAgeMenarche()) == 2) {
				rootFactors.add("Age Menarche");
				percent=45.0;
				// 12-13
				// YES
			} else {
				Double temp=Double.valueOf(patient.getBMI());
				Integer temp2=temp.intValue();
				if (temp2 == 2) {
					rootFactors.add("BMI");
					percent=28.0;
					// YES
				} else {
					percent=0.0;
					// NO
				}
			}
		} else {
			if(Integer.valueOf(patient.getMenopause())==2){
				percent=83.0;
				rootFactors.add("Menopause");
				//YES
			}
			else{
				if(Integer.valueOf(patient.getRace())==1){
					percent=82.0;
					rootFactors.add("Race");
					//YES
				}else{
					//NO
				}
			}

		}
		if(rootFactors.size()>0)
			return true;
		else 
			return false;
	}
	
	public static ArrayList<String> getRootFactors(){
		return rootFactors;
	}
	
	public static double getPercent(){
		return percent;
	}

}
