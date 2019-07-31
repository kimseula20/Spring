package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller()
//@RequestMapping("/register")
public class RegisterController {

	@RequestMapping("/register/step1"/*"/register/step1"*/)
	public String handleStep1() {
		return "register/step1";
	}
	
	@PostMapping("/step2")
	public String handleStep2(HttpServletRequest request) {
		String agreeParam = request.getParameter("agree");
		if(agreeParam == null || !agreeParam.equals("true")) {
			return "step1";
		}
		return "register/step2";
	}
	
	@RequestMapping("/step3")
	public String handleStep3() {
		return "register/step3";
	}
}
