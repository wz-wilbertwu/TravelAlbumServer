package controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import custome_interface.UserRepository;
import model.User;

@Controller
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
			userRepository.add(user);
		    return new User(user.getName(), user.getPassword(), user.getEmail());
		  }
}
