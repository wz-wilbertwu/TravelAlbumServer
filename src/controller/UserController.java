package controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import model.User;

@Controller
@RequestMapping("/User")
public class UserController {
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String showRegisterForm() {
		return "registerForm";
	}
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public @ResponseBody User processRegistration(
		      @Valid User user, 
		      Errors errors) {
		    /*if (errors.hasErrors()) {
		      return "registerForm";
		    }*/
		    return new User(user.getName(), user.getPassword(), user.getEmail());
		  }
}
