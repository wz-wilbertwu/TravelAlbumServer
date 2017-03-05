package controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import custome_interface.TravelRepository;
import custome_interface.UserRepository;
import model.Travel;
import model.User;
import testTool.MyTool;

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
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String showUpdateTravelForm() {
		return "updateTravelForm";
	}
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public @ResponseBody Travel processUpdate(
		      @Valid Travel travel, 
		      Errors errors) {
		    /*if (errors.hasErrors()) {
		      return "registerForm";
		    }*/
			return travelRepository.update(travel);
		  }
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public @ResponseBody Travel showTravel(@PathVariable("id") String id){
		return travelRepository.query(id);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public @ResponseBody List<Travel> queryTravels(
			@RequestParam(value="user_id") String user_id
			) {
		return travelRepository.queryAll(user_id);
	}
	
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public @ResponseBody Travel processDelete(
			@PathVariable("id") String id
		      ) {
			MyTool.print(id);
			return travelRepository.delete(id);
		  }
}
