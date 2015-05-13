package com.cmpe239.team11.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="DNA2")
public class DNA {


	public  String dnaSequence;
	public  int A;
	public  int G;
	public  int C;
	public  int T;
	public  String geneType; // Normal gene or Affected gene
}
