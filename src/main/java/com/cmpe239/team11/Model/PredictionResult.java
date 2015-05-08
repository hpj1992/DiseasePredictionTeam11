package com.cmpe239.team11.Model;

import java.util.ArrayList;

public class PredictionResult {

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isCancerResult() {
		return cancerResult;
	}
	public void setCancerResult(boolean cancerResult) {
		this.cancerResult = cancerResult;
	}
	public ArrayList<String> getFactorsForCancer() {
		return factorsForCancer;
	}
	public void setFactorsForCancer(ArrayList<String> factorsForCancer) {
		this.factorsForCancer = factorsForCancer;
	}
	public ArrayList<String> getRecommendatations() {
		return recommendatations;
	}
	public void setRecommendatations(ArrayList<String> recommendatations) {
		this.recommendatations = recommendatations;
	}
	private String email;
	private boolean cancerResult;
	private ArrayList<String> factorsForCancer;
	private ArrayList<String> recommendatations;
	
}
