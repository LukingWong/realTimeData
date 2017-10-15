package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dao.TriesRepository;
import models.Tries;

@RestController
@SuppressWarnings({ "rawtypes", "unchecked" })
public class MainController {

	@Autowired(required=true)
	private TriesRepository triesRepository;
	

	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Tries> getAllTries(){
		return triesRepository.findAll();
	}
	
	

}
