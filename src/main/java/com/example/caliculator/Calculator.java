package com.example.caliculator;

import java.time.LocalDate;

public class Calculator {
    private double averageSalary;
    private Integer numberOfDays;
    private LocalDate starDay;
    private LocalDate stopDay;
        public Calculator(double annualSalary,Integer numberOfDays){
        	if(averageSalary>=0) {
            this.averageSalary = annualSalary;}
        	
            this.numberOfDays = numberOfDays;
        }
        public Calculator(double annualSalary,LocalDate starDay,LocalDate stopDay){
            this.averageSalary = annualSalary;
            this.starDay = starDay;
            this.stopDay = stopDay;
        }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public double getAnnualSalary() {
        return averageSalary;
    }

    public void setAnnualSalary(double annualSalary) {
        this.averageSalary = annualSalary;
    }
    public double getResult() {
    	double result = 0;
    	if(numberOfDays!=null&&numberOfDays>0) {
    	return result =(averageSalary/29.3)*numberOfDays;}
    	return  result;
    }
}
