package controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import custome_interface.TravelRepository;
import custome_interface.UserRepository;
import model.Travel;
import model.User;

@Controller
@RequestMapping("/Travel")
public class TravelController {
	private TravelRepository travelRepository;
	@Autowired
	public TravelController(TravelRepository travelRepository) {
		this.travelRepository = travelRepository;
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String showRegisterForm() {
		return "addTravelForm";
	}
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public @ResponseBody Travel processRegistration(
		      @Valid Travel travel, 
		      Errors errors) {
		    /*if (errors.hasErrors()) {
		      return "registerForm";
		    }*/
			return travelRepository.add(travel);
		  }
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public @ResponseBody Travel showUser(@PathVariable("id") String id){
		return travelRepository.query(id);
	}
}
