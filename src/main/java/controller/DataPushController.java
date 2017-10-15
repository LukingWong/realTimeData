package controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import dao.TriesRepository;
import models.Tries;
@EnableScheduling
@Controller
public class DataPushController {
	@Autowired(required = true)
	private TriesRepository triesRepository;
	
	@Autowired
	private SimpMessagingTemplate template;

	
	@Scheduled(fixedRate = 2000)
	public void pushData() {
		Iterable<Tries> tries = triesRepository.findAll();
		this.template.convertAndSend("/channel/public", tries);
	}
}
