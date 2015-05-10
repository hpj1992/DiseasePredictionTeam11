package com.cmpe239.team11.Manager;

import com.cmpe239.team11.DAO.DNADAO;
import com.cmpe239.team11.Model.DNA;

public class DNAManager {

	public static DNA generateCount(DNA dna) {
		// TODO Auto-generated method stub
		return DNADAO.generateCount(dna);
		
	}
	
	public static void addNewData(DNA dna){
		DNADAO.addNewDNA(dna);
	}

}
