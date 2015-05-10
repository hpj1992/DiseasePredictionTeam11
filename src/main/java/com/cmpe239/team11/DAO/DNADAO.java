package com.cmpe239.team11.DAO;

import com.cmpe239.team11.Model.DNA;
import com.cmpe239.team11.Utility.MongoConfig;

public class DNADAO {

	public static DNA generateCount(DNA dna) {
		// TODO Auto-generated method stub
		String line=dna.dnaSequence;
		int a=0,g=0,c=0,t=0;
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
		dna.A=a;
		dna.G=g;
		dna.C=c;
		dna.T=t;
		return dna;
	}

	public static void addNewDNA(DNA dna){
		System.out.println(dna.geneType);
		if(((dna.geneType.length())>0)){
		MongoConfig.getMongoOperationsObj().save(dna);
		}
		else{
			System.out.println("GENE TYPE NOT DEFINED");
		}
	}
}
