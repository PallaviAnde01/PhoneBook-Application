package com.PallaviAnde.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.PallaviAnde.Service.ContactService;

//@RestController
@Controller
@RequestMapping("/api/phoneBook")
public class ContactController {

	@Autowired
	private ContactService contactService;
	
	@GetMapping("/contacts")
	public String phoneBook() {
		return "Contact";
	}
}
