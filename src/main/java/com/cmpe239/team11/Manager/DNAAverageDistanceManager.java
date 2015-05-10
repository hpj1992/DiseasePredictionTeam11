package com.cmpe239.team11.Manager;

import com.cmpe239.team11.DAO.DNAAverageDistanceDAO;
import com.cmpe239.team11.Model.DNA;

public class DNAAverageDistanceManager {

	public static boolean getDNAClusterAndUpdateDatabase(DNA dna){
		return DNAAverageDistanceDAO.getDNACluster(dna);
	}
	
	public static double getPercent(){
		return DNAAverageDistanceDAO.getPercent();
	}
}
