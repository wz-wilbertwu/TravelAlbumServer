package controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import custome_interface.UserRepository;
import model.User;

@RequestMapping("/User")
public class UserController {
	private UserRepository userRepository;
	@Autowired
	public UserController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
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
			return userRepository.add(user);
		  }
	
	@RequestMapping(value="/{userId}", method=RequestMethod.GET)
	public @ResponseBody User showUser(@PathVariable("userId") String userId){
		return userRepository.query(userId);
	}
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String showLoginForm() {
		return "registerForm";
	}
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public @ResponseBody User processLogin(
		      @Valid User user, 
		      Errors errors) {
		    /*if (errors.hasErrors()) {
		      return "registerForm";
		    }*/
			return userRepository.login(user);
		  }
}
