package com.PallaviAnde.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

//create contact:
	@PostMapping("/")
	public ResponseEntity<String> createContact(@Valid @RequestBody Contacts contacts){
		boolean createContact = contactService.createContact(contacts);
		
		return new ResponseEntity<String>("Contact save successfully",HttpStatus.CREATED);
		}
	
//update contact:
	@PutMapping("/{contactId}")
	public ResponseEntity<String> updateContact(@Valid @RequestBody Contacts contacts,@PathVariable Integer contactId){
		Contacts updateContact = contactService.updateContact(contacts, contactId);
		
		return new ResponseEntity<String>("Contact updated successfully",HttpStatus.OK);
		}
	
	
}
