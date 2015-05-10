package com.cmpe239.team11.Model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "DNAAverageDistances")
public class DNAAverageDistances {

	public double getA() {
		return A;
	}

	public void setA(double a) {
		A = a;
	}

	public double getG() {
		return G;
	}

	public void setG(double g) {
		G = g;
	}

	public double getC() {
		return C;
	}

	public void setC(double c) {
		C = c;
	}

	public double getT() {
		return T;
	}

	public void setT(double t) {
		T = t;
	}

	private double A;
	private double G;
	private double C;
	private double T;
	private String geneType;

	public String getGeneType() {
		return geneType;
	}

	public void setGeneType(String geneType) {
		this.geneType = geneType;
	}

}
