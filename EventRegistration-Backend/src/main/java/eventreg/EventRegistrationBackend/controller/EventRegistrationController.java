package eventreg.EventRegistrationBackend.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import eventreg.EventRegistrationBackend.service.EventRegistrationService;

@CrossOrigin(origins = "*")
@RestController
public class EventRegistrationController{
    @Autowired
	private EventRegistrationService service;
}