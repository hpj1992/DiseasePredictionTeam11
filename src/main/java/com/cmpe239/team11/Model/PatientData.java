package com.cmpe239.team11.Model;

public class PatientData {

	private String email;
	private String age;
	private DNA dna;
	private String menopause;
	private String bmi;
	private String ageMenarche;
	private String race;
	
	public String getAgeMenarche() {
		return ageMenarche;
	}
	public void setAgeMenarche(String ageMenarche) {
		this.ageMenarche = ageMenarche;
	}
	public String getRace() {
		return race;
	}
	public void setRace(String race) {
		this.race = race;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public DNA getDNA() {
		return dna;
	}
	public void setDNA(DNA dNA) {
		dna = dNA;
	}
	public String getMenopause() {
		return menopause;
	}
	public void setMenopause(String menopause) {
		this.menopause = menopause;
	}
	public String getBMI() {
		return bmi;
	}
	public void setBMI(String bMI) {
		bmi = bMI;
	}
	
}
