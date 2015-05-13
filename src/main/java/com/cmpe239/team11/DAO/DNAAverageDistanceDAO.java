package com.cmpe239.team11.DAO;

import java.util.ArrayList;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.cmpe239.team11.Model.DNA;
import com.cmpe239.team11.Model.DNAAverageDistances;
import com.cmpe239.team11.Utility.ApplicationConstants;
import com.cmpe239.team11.Utility.MongoConfig;

public class DNAAverageDistanceDAO {

	public static double percent=0.0;
	public static void UpdateDNAAverageDistance(DNAAverageDistances oldDistances,DNA newDNA) {
		
		
		Query query=new Query();
		query.addCriteria(Criteria.where("geneType").in(oldDistances.getGeneType()));
		
		long totalDocs=MongoConfig.getMongoOperationsObj().count(query, DNA.class);
		
		double newA=(oldDistances.getA()*totalDocs+newDNA.A)/(totalDocs+1);
		double newG=(oldDistances.getG()*totalDocs+newDNA.G)/(totalDocs+1);
		double newC=(oldDistances.getC()*totalDocs+newDNA.C)/(totalDocs+1);
		double newT=(oldDistances.getT()*totalDocs+newDNA.T)/(totalDocs+1);

		Update update=new Update();
		update.set("A", newA);
		update.set("G", newG);
		update.set("C", newC);
		update.set("T", newT);
		System.out.println("OLD A:"+oldDistances.getA()+" NEW A:"+newA);
		System.out.println("OLD G:"+oldDistances.getG()+" NEW G:"+newG);
		System.out.println("OLD C:"+oldDistances.getC()+" NEW C:"+newC);
		System.out.println("OLD T:"+oldDistances.getT()+" NEW T:"+newT);
		
		MongoConfig.getMongoOperationsObj().findAndModify(query, update, DNAAverageDistances.class);
		
	}

	public static double getDistance(DNAAverageDistances distance, DNA newDNA) {

		double aDiff = distance.getA() - newDNA.A;
		double gDiff = distance.getG() - newDNA.G;
		double cDiff = distance.getC() - newDNA.C;
		double tDiff = distance.getT() - newDNA.T;

		double aSqr = Math.pow(aDiff, 2);
		double gSqr = Math.pow(gDiff, 2);
		double cSqr = Math.pow(cDiff, 2);
		double tSqr = Math.pow(tDiff, 2);

		double output = Math.sqrt(aSqr + gSqr + cSqr + tSqr);

		return output;
	}
	public static double getDistanceNormal(DNAAverageDistances distance, DNA newDNA) {

		double aDiff = 14 - newDNA.A;
		double gDiff = 20 - newDNA.G;
		double cDiff = 20 - newDNA.C;
		double tDiff = 14 - newDNA.T;

		double aSqr = Math.pow(aDiff, 2);
		double gSqr = Math.pow(gDiff, 2);
		double cSqr = Math.pow(cDiff, 2);
		double tSqr = Math.pow(tDiff, 2);

		double output = Math.sqrt(aSqr + gSqr + cSqr + tSqr);

		return output;
	}
	
	public static double getDistanceAffected(DNAAverageDistances distance, DNA newDNA) {

		double aDiff = 18 - newDNA.A;
		double gDiff = 18 - newDNA.G;
		double cDiff = 19 - newDNA.C;
		double tDiff = 18 - newDNA.T;

		double aSqr = Math.pow(aDiff, 2);
		double gSqr = Math.pow(gDiff, 2);
		double cSqr = Math.pow(cDiff, 2);
		double tSqr = Math.pow(tDiff, 2);

		double output = Math.sqrt(aSqr + gSqr + cSqr + tSqr);

		return output;
	}
	public static boolean getDNACluster(DNA dna){
		Query query = new Query();
		query.addCriteria(Criteria.where("geneType").in(
				ApplicationConstants.NORMAL_GENE));
		DNAAverageDistances normalDNADistances = (DNAAverageDistances) MongoConfig
				.getMongoOperationsObj().findOne(query, DNAAverageDistances.class);
		Query query2 = new Query();
		query2.addCriteria(Criteria.where("geneType").in(
				ApplicationConstants.AFFECTED_GENE));
		DNAAverageDistances affectedDNADistances = (DNAAverageDistances) MongoConfig
				.getMongoOperationsObj()
				.findOne(query2, DNAAverageDistances.class);
		double distanceWithNormal=getDistanceNormal(normalDNADistances,dna);
		double distanceWithAffected=getDistanceAffected(affectedDNADistances,dna);
		System.out.println("affected:" + distanceWithAffected +"normal:"+ distanceWithNormal);
		//double percent=0;
		if(distanceWithAffected < distanceWithNormal){
			percent=1-((distanceWithAffected)/(distanceWithNormal+distanceWithAffected));
			System.out.println("m here yo");
			UpdateDNAAverageDistance(affectedDNADistances, dna);
			return true;
		}else{
			// CANCER WONT HAPPEN
			percent=1-((distanceWithNormal)/(distanceWithNormal+distanceWithAffected));
			UpdateDNAAverageDistance(normalDNADistances, dna);
			return false;
		}
		
		
	}
	
	public static double getPercent(){
		return percent;
	}

	public static void generateAverageDistance(String geneType){
		Query query=new Query();
		query.addCriteria(Criteria.where("geneType").is(geneType));
		
		ArrayList<DNA> allDNA=(ArrayList<DNA>) MongoConfig.getMongoOperationsObj().find(query, DNA.class);
		double allA=0,allG=0,allC=0,allT=0;
		for(int i=0;i<allDNA.size();i++){
			allA+=allDNA.get(i).A;
			allG+=allDNA.get(i).G;
			allC+=allDNA.get(i).C;
			allT+=allDNA.get(i).T;
		}
		
		DNAAverageDistances affectedDistance=new DNAAverageDistances();
		affectedDistance.setA(allA/allDNA.size());
		affectedDistance.setG(allG/allDNA.size());
		affectedDistance.setC(allC/allDNA.size());
		affectedDistance.setT(allT/allDNA.size());
		affectedDistance.setGeneType(geneType);
		
		MongoConfig.getMongoOperationsObj().save(affectedDistance);
	}
}
