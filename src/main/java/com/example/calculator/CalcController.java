package com.example.calculator;
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
   public String calculate(	@RequestParam( name = "averageSalary",required = false) Double averageSalary,
                            @RequestParam(name = "numberOfDay",required = false) Integer numberOfDay,
    						@RequestParam(name = "startDay",required = false)LocalDate startDay,
    						@RequestParam(name = "stopDay", required = false) LocalDate stopDay,
    						Model model){



		
        model.addAttribute("vacationPayments", String.format("%.2f", new Calculator(averageSalary,numberOfDay,startDay,stopDay).getResult()));
        
                return "calculate";
    }


}
