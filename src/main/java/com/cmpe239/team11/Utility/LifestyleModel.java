package com.cmpe239.team11.Utility;

import com.cmpe239.team11.Model.PatientData;

public class LifestyleModel {

public static double getBMI(double height,double weight){
	//height in inches
	//weight in pound
	
	return (weight*703)/(Math.pow(height, 2));
}
}
