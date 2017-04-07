package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import custome_interface.SyncRepository;

@Controller
@RequestMapping("/Sync")
public class SyncController {
	private SyncRepository syncRepository;
	@Autowired
	public SyncController(SyncRepository syncRepository) {
		this.syncRepository = syncRepository;
	}
	
	
}
