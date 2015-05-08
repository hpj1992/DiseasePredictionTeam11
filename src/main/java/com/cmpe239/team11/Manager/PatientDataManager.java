package com.cmpe239.team11.Manager;

import com.cmpe239.team11.DAO.PatientDataDAO;
import com.cmpe239.team11.Model.PatientData;

public class PatientDataManager {

	public static void addPatientData(PatientData patient){
		PatientDataDAO.addPatientData(patient);
	}
	
	public static PatientData getPatientData(String email){
		return PatientDataDAO.getPatientData(email);
	}
	
	public static void updatePatientData(PatientData patientData){
		PatientDataDAO.updatePatientData(patientData);
	}
}
