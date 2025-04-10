package com.example.caliculator;

import org.springframework.stereotype.Service;
@Service

public class CalcService {
	public CalcService() {}
	public double getResult(double averageSalary,int numberOfDays ) {
		double result = 0;
		return result =(averageSalary/29.3)*numberOfDays;
	}

}
