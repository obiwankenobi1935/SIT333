package web.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import web.service.LoginService;
import web.service.MathQuestionService;
import web.service.DateUtilityService;
import web.service.ScienceQuestionService;

@Controller
@RequestMapping("/")
public class RoutingServlet {

	@GetMapping("/")
	public String welcome() {
		System.out.println("Welcome ...");
		return "view-welcome";
	}
	

	@GetMapping("/login")
	public String loginView() {
		System.out.println("login view...");
		return "view-login";
	}
	
	@GetMapping("/welcome")
	public String welcomeEnd() {
	    System.out.println("welcome end...");
	    return "view-welcome";
	}
	

	@PostMapping("/login")
	public RedirectView login(
			HttpServletRequest request, 
			RedirectAttributes redirectAttributes) {
		System.out.println("login form...");
		String username = request.getParameter("username");
		String password = request.getParameter("passwd");
		String dob = request.getParameter("dob");
		
		System.out.println("Username/password: " + username + ", " + password);
		
		RedirectView redirectView = null;
		if (LoginService.login(username, password, dob)) {
			redirectView = new RedirectView("/q1", true);
		} else {
			// Login failed, stay with login page.
			//
			redirectView = new RedirectView("/login", true);
			// Show error message
			//
			redirectAttributes.addFlashAttribute("message", "Incorrect credentials.");
		}
		
		return redirectView;
	}
	

	@GetMapping("/q1")
	public String q1View() {		
		System.out.println("q1 view...");
		return "view-q1";
	}

	@PostMapping("/q1")
	public RedirectView q1(
			HttpServletRequest request, 
			RedirectAttributes redirectAttributes) {
		System.out.println("q1 form...");
		String number1 = request.getParameter("number1");
		String number2 = request.getParameter("number2");
		String resultUser = request.getParameter("result");
		
		double calculatedResult = MathQuestionService.q1Addition(number1, number2);
		System.out.println(
				"User result: " + resultUser + ", answer: " + calculatedResult);
		
		RedirectView redirectView = null;
		if (!Double.isNaN(calculatedResult) && calculatedResult == Double.valueOf(resultUser)) {
			redirectView = new RedirectView("/q2", true);
		} else {
			// Q1 wrong.
			//
			redirectView = new RedirectView("/q1", true);
			// Show error message
			//
			redirectAttributes.addFlashAttribute("message", "Wrong answer, try again.");
		}		
		return redirectView;
	}	
	

	@GetMapping("/q2")
	public String q2View() {		
		System.out.println("q2 view...");
		return "view-q2";
	}	


	@PostMapping("/q2")
	public RedirectView q2(HttpServletRequest request, RedirectAttributes redirectAttributes) {
		System.out.println("q1 form...");
		String number1 = request.getParameter("number1");
		String number2 = request.getParameter("number2");
		String resultUser = request.getParameter("result");
		
		double calculatedResult = MathQuestionService.q2Subtraction(number1, number2);
		System.out.println("User result: " + resultUser + ", answer: " + calculatedResult);
		
		RedirectView redirectView = null;
		if (!Double.isNaN(calculatedResult) && calculatedResult == Double.valueOf(resultUser)) {
			redirectView = new RedirectView("/q3", true);
		} else {
			// Q1 wrong
			//
			redirectView = new RedirectView("/q2", true);
			// Show error message
			//
			redirectAttributes.addFlashAttribute("message", "Wrong answer, try again.");
		}		
		return redirectView;
	}	
	

	@GetMapping("/q3")
	public String q3View() {		
		System.out.println("q3 view...");
		return "view-q3";
	}
	
	@PostMapping("/q3")
	public RedirectView q3(HttpServletRequest request, RedirectAttributes redirectAttributes) {
	    System.out.println("q3 form...");
	    String number1 = request.getParameter("number1");
	    String number2 = request.getParameter("number2");
	    String resultUser = request.getParameter("result");

	    double calculatedResult = MathQuestionService.q3Multiplication(number1, number2);
	    System.out.println("User result: " + resultUser + ", answer: " + calculatedResult);

	    RedirectView redirectView = null;
	    if (!Double.isNaN(calculatedResult) && calculatedResult == Double.valueOf(resultUser)) {
	        redirectView = new RedirectView("/q4", true);
	    } else {
	        redirectView = new RedirectView("/q3", true);
	        redirectAttributes.addFlashAttribute("message", "Wrong answer, try again.");
	    }
	    return redirectView;
	}
	
	@GetMapping("/q4")
	public String q4View() {
	    System.out.println("q4 view...");
	    return "view-q4";
	}

	@PostMapping("/q4")
	public RedirectView q4(HttpServletRequest request, RedirectAttributes redirectAttributes) {
	    System.out.println("q4 form...");
	    String startDate = request.getParameter("startDate");
	    String days = request.getParameter("days");
	    String resultUser = request.getParameter("result");

	    String calculatedResult = DateUtilityService.dateAfterDays(startDate, days);

	    RedirectView redirectView = null;
	    if (calculatedResult != null && calculatedResult.equals(resultUser)) {
	        redirectView = new RedirectView("/q5", true);
	    } else {
	        redirectView = new RedirectView("/q4", true);
	        redirectAttributes.addFlashAttribute("message", "Wrong answer, try again.");
	    }
	    return redirectView;
	}

	@GetMapping("/q5")
	public String q5View() {
	    System.out.println("q5 view...");
	    return "view-q5";
	}

	@PostMapping("/q5")
	public RedirectView q5(HttpServletRequest request, RedirectAttributes redirectAttributes) {
	    System.out.println("q5 form...");
	    String date1 = request.getParameter("date1");
	    String date2 = request.getParameter("date2");
	    String resultUser = request.getParameter("result");

	    long calculatedResult = DateUtilityService.daysBetween(date1, date2);

	    RedirectView redirectView = null;
	    if (calculatedResult != Long.MIN_VALUE && calculatedResult == Long.parseLong(resultUser.trim())) {
	        redirectView = new RedirectView("/q6", true);
	    } else {
	        redirectView = new RedirectView("/q5", true);
	        redirectAttributes.addFlashAttribute("message", "Wrong answer, try again.");
	    }
	    return redirectView;
	}

	@GetMapping("/q6")
	public String q6View() {
	    System.out.println("q6 view...");
	    return "view-q6";
	}

	@PostMapping("/q6")
	public RedirectView q6(HttpServletRequest request, RedirectAttributes redirectAttributes) {
	    System.out.println("q6 form...");
	    String mass = request.getParameter("mass");
	    String acceleration = request.getParameter("acceleration");
	    String resultUser = request.getParameter("result");

	    double calculatedResult = ScienceQuestionService.calculateForce(mass, acceleration);

	    RedirectView redirectView = null;
	    if (!Double.isNaN(calculatedResult) && calculatedResult == Double.valueOf(resultUser)) {
	        redirectView = new RedirectView("/welcome", true);
	    } else {
	        redirectView = new RedirectView("/q6", true);
	        redirectAttributes.addFlashAttribute("message", "Wrong answer, try again.");
	    }
	    return redirectView;
	}
	
}
