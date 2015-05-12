package com.cmpe239.team11.Utility;

import com.cmpe239.team11.Model.PatientData;

public class LifestyleModel {

public static double getBMI(double height,double weight){
	//height in inches
	//weight in pound
	
	return (weight*703)/(Math.pow(height, 2));
}
public static double idealBMI(double height,double weight){
	double bmi = getBMI(height, weight);
	if(bmi >= 18.5 && bmi<=24.9){
		return 0.0;
	}
	else 
	{ if(bmi < 18.5){
		return (((18.5 - bmi)/18.5)*100);
	}
	else if(bmi >=25.0 && bmi<=29.9){
		
		return (((25.0 - bmi)/25.0)*100);
	}
	else{
		return (((30.0 - bmi)/30.0)*100);
	}
	}
}
}
