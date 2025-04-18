package com.example.caliculator;

import java.time.LocalDate;
import java.time.Month;
import java.time.MonthDay;
import java.util.HashSet;
import java.util.Set;

public class Calculator {
    public static final double AVERAGE_NUMBER_OF_DAYS_PER_MONTH = 29.3;
    public static  final Set<MonthDay> HOLIDAYS = new HashSet<>();

    static {
        HOLIDAYS.add(MonthDay.of(Month.JANUARY,1));
        HOLIDAYS.add(MonthDay.of(Month.JANUARY, 2));
        HOLIDAYS.add(MonthDay.of(Month.JANUARY, 3));
        HOLIDAYS.add(MonthDay.of(Month.JANUARY, 4));
        HOLIDAYS.add(MonthDay.of(Month.JANUARY, 5));
        HOLIDAYS.add(MonthDay.of(Month.JANUARY, 6));
        HOLIDAYS.add(MonthDay.of(Month.JANUARY, 7));
        HOLIDAYS.add(MonthDay.of(Month.JANUARY, 8));
        HOLIDAYS.add(MonthDay.of(Month.FEBRUARY, 23));
        HOLIDAYS.add(MonthDay.of(Month.MARCH, 8));
        HOLIDAYS.add(MonthDay.of(Month.APRIL,29)); //regional holiday
        HOLIDAYS.add(MonthDay.of(Month.MAY, 1));
        HOLIDAYS.add(MonthDay.of(Month.MAY, 9));
        HOLIDAYS.add(MonthDay.of(Month.JUNE, 12));
        HOLIDAYS.add(MonthDay.of(Month.NOVEMBER, 4));
    }
    private Double averageSalary;
    private LocalDate startDay;
    private LocalDate stopDay;

        public Calculator(double averageSalary,LocalDate startDay,LocalDate stopDay){
            this.averageSalary = averageSalary;
            this.startDay = startDay;
            this.stopDay = stopDay;
        }



    public double getAnnualSalary() {
        return averageSalary;
    }

    public void setAnnualSalary(double annualSalary) {
        this.averageSalary = averageSalary;
    }
    public  int getNumberOfVacationDays(LocalDate startDay,LocalDate stopDay){
            int numberOfDays = 0;
            if(isValidStartDay(startDay)&&isValidStopDay(stopDay)){
                for(LocalDate day = startDay;(!day.isAfter(stopDay));day = day.plusDays(1)){
                    if(!isHoliday(day)){
                        numberOfDays++;
                        System.out.println(numberOfDays);
                    }
                }
            }
            System.out.println(numberOfDays);
            return numberOfDays;
    }

    public boolean isValidStartDay(LocalDate startDay){
            return startDay!=null;
    }
    public boolean isValidStopDay(LocalDate stopDay){
            return stopDay!=null&&(startDay.isBefore(stopDay)||startDay.isEqual(stopDay));
    }
    public boolean isValidAverageSalary(Double averageSalary){
            return averageSalary!=null&&averageSalary>0;
    }
    public boolean isHoliday(LocalDate day){
            return HOLIDAYS.contains(toMonthDay(day));
    }

    public Double getResult() {
        double result = 0;
        if(isValidAverageSalary(averageSalary)
                &&isValidStartDay(startDay)
                &&isValidStopDay(stopDay)){
            result = averageSalary/AVERAGE_NUMBER_OF_DAYS_PER_MONTH*getNumberOfVacationDays(startDay,stopDay);
        }

        return  result;
    }
    private static MonthDay toMonthDay(LocalDate localDate) {
        return MonthDay.of(localDate.getMonth(), localDate.getDayOfMonth());
    }

}
