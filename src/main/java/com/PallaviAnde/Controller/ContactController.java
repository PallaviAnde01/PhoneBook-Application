package com.PallaviAnde.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.PallaviAnde.Model.Contacts;
import com.PallaviAnde.Service.ContactService;


@RestController
@RequestMapping("/api/phonebook")
public class ContactController {

	@Autowired
	private ContactService contactService;
	
	@PostMapping("/")
	public ResponseEntity<String> createContact(@Valid @RequestBody Contacts contacts){
		boolean createContact = contactService.createContact(contacts);
		
		return new ResponseEntity<String>("Contact save successfully",HttpStatus.CREATED);
		}
	
}
