package com.example.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CaliculatorApplicationTests  {
	private  Calculator calculator  = new Calculator();
	@Test
	void contextLoads() {
	}

	@Test
	void testCalculatorResult() {
		LocalDate startDay = LocalDate.of(2025,04,28);
		LocalDate stopDay = LocalDate.of(2025,04,30);
		calculator.setStartDay(startDay);
		calculator.setStopDay(stopDay);
		calculator.setAnnualSalary(29300);
		assertEquals(2,calculator.getNumberOfVacationDays(startDay,stopDay));
		Double result = calculator.getResult();
		Double expected = 2000.00;

		assertEquals(expected, result,0.01);
	}

	@Test
	void testNegativeSalary(){
		calculator.setAnnualSalary(-1000.00);
		calculator.setStartDay(LocalDate.of(2025,04,01));
		calculator.setStopDay(LocalDate.of(2025,04,03));
		assertEquals(0.0,calculator.getResult(),0.001);
	}
	@Test
	void testNotValidDate(){
		calculator.setAnnualSalary(1000.00);
		calculator.setStartDay(LocalDate.of(2025,04,11));
		calculator.setStopDay(LocalDate.of(2025,04,03));
		assertEquals(0.0,calculator.getResult(),0.001);
	}

}
