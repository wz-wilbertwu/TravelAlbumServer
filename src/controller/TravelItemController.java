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

import custome_interface.TravelItemRepository;
import custome_interface.TravelRepository;
import model.Travel;
import model.TravelItem;
import testTool.MyTool;

@Controller
@RequestMapping("/TravelItem")
public class TravelItemController {
	private TravelItemRepository travelItemRepository;
	@Autowired
	public TravelItemController(TravelItemRepository travelItemRepository) {
		this.travelItemRepository = travelItemRepository;
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String showRegisterForm() {
		return "addTravelItemForm";
	}
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public @ResponseBody TravelItem processRegistration(
		      @Valid TravelItem travelItem, 
		      Errors errors) {
		    /*if (errors.hasErrors()) {
		      return "registerForm";
		    }*/
			return travelItemRepository.add(travelItem);
		  }
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String showUpdateTravelItemForm() {
		return "updateTravelItemForm";
	}
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public @ResponseBody TravelItem processUpdate(
		      @Valid TravelItem travelItem, 
		      Errors errors) {
		    /*if (errors.hasErrors()) {
		      return "registerForm";
		    }*/
			return travelItemRepository.update(travelItem);
		  }
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public @ResponseBody TravelItem showTravel(@PathVariable("id") String id){
		return travelItemRepository.query(id);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public @ResponseBody List<TravelItem> queryTravels(
			@RequestParam(value="travel_id") String travel_id
			) {
		return travelItemRepository.queryAll(travel_id);
	}
	
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public @ResponseBody TravelItem processDelete(
			@PathVariable("id") String id
		      ) {
			MyTool.print(id);
			return travelItemRepository.delete(id);
		  }
}
