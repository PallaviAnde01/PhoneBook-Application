package com.PallaviAnde.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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

//get all contacts:
	@GetMapping("/")
	public ResponseEntity<List<Contacts>> getAllContact(){
		List<Contacts> allContact = contactService.getAllContact();
		
		return new ResponseEntity<List<Contacts>>(allContact,HttpStatus.OK);
		}
	
//get contact by id:
	@GetMapping("/{contactId}")
	public ResponseEntity<Contacts> getContactById(@PathVariable Integer contactId){
		Contacts contacts = contactService.getContactById(contactId);
		
		return new ResponseEntity<Contacts>(contacts,HttpStatus.OK);
		} 
	
//delete contact:
	@DeleteMapping("/hard/{contactId}")
	public ResponseEntity<String> hardDeleteContact(@PathVariable Integer contactId){
		contactService.hardDeleteContact(contactId);
		
		return new ResponseEntity<String>("Contact deleted successfully",HttpStatus.OK);
		}
	
	@DeleteMapping("/soft/{contactId}")
	public ResponseEntity<String> softDeleteContact(@PathVariable Integer contactId){
		contactService.softDeleteContact(contactId);
		
		return new ResponseEntity<String>("Contact deleted successfully",HttpStatus.OK);
		}
}





















