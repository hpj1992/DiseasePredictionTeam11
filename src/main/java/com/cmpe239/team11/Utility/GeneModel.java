package com.cmpe239.team11.Utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.cmpe239.team11.Model.DNA;
import com.cmpe239.team11.Model.DNAAverageDistances;

public class GeneModel {

	public static void updateGeneModel() {
		// TODO Auto-generated method stub

	}

	public static void uploadFileDataToServer() {
		try {

			BufferedReader br = new BufferedReader(new FileReader(new File(
					ApplicationConstants.affectedGeneDataPath)));
			int id = 1;
			int allA = 0, allG = 0, allC = 0, allT = 0;
			for (String line; (line = br.readLine()) != null;) {
				// process the line.
				if (id > 1986 && id < 5001 && !line.contains("N")) {
					System.out.println(line);
					DNA dna = new DNA();
					int a = 0, g = 0, c = 0, t = 0;
					dna.dnaSequence = line;
					dna.geneType = ApplicationConstants.AFFECTED_GENE;
					System.out.println(line.length());
					System.out.println(line.trim().contains("N"));

					for (int i = 0; i < line.length(); i++) {
						if (line.charAt(i) == 'A' || line.charAt(i) == 'a') {
							a++;
						} else if (line.charAt(i) == 'G'
								|| line.charAt(i) == 'g') {
							g++;
						} else if (line.charAt(i) == 'C'
								|| line.charAt(i) == 'c') {
							c++;
						} else if (line.charAt(i) == 'T'
								|| line.charAt(i) == 't') {
							t++;
						}
					}
					dna.A = a;
					dna.G = g;
					dna.C = c;
					dna.T = t;
					System.out.println(a);
					allA = (allA * (id - 1) + a) / id;
					allG = (allG * (id - 1) + g) / id;
					allC = (allC * (id - 1) + c) / id;
					allT = (allT * (id - 1) + t) / id;
					MongoConfig.getMongoOperationsObj().save(dna);
					if (id % 500 == 0) {
						System.gc();
					}

					id++;

				} else {
					if (id < 5001)
						id++;
					else
						break;
				}
			}
			// line is not visible here.
			System.out.println("All A" + allA);
			System.out.println("All G" + allG);
			System.out.println("All C" + allC);
			System.out.println("All T" + allT);
			System.out.println("Total ID:" + id);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out
					.println("Error in uploading file data to server.Check your file path.");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("IO Exception");
			e.printStackTrace();
		}

	}

	public static void addNewGene(DNA dna) {
		long count = MongoConfig.getMongoOperationsObj().count(new Query(),
				DNA.class);
	}
	
	public static long getCount(String str){
		Query query=new Query();
		query.addCriteria(Criteria.where("dnaSequence").in(str));
		
		long totalDocs=MongoConfig.getMongoOperationsObj().count(query, DNA.class);
		return totalDocs;
		
	}
}
