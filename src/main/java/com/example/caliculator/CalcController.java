package com.example.caliculator;
import java.time.LocalDate;

//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;


@Controller
@RequestMapping("/calculate")
public class CalcController {
	
	
   @GetMapping
   public String calculate(	@RequestParam( name = "averageSalary",required = false,defaultValue = "0") double averageSalary,
    						@RequestParam(name = "numberOfDays",required = false)Integer numberOfDays,
    						@RequestParam(name = "startDay",required = false)LocalDate startDay,
    						@RequestParam(name = "stopDay", required = false) LocalDate stopDay,
    						Model model){
	   System.out.println(startDay);
	   System.out.println(stopDay);
	   System.out.println(numberOfDays);
	   System.out.println(new Calculator(averageSalary,numberOfDays).getResult());
    	
		
        model.addAttribute("vacationPayments", String.format("%.2f", new Calculator(averageSalary,numberOfDays).getResult()));
        
                return "calculate";
    }


}
