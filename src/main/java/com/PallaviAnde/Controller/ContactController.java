package com.PallaviAnde.Controller;

import java.util.List;
import java.util.Map;

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
import com.PallaviAnde.Util.AppConstant;
import com.PallaviAnde.Util.AppProps;


@RestController
@RequestMapping("/api/phonebook")
public class ContactController {

	@Autowired
	private ContactService contactService;
	
	@Autowired
	private AppProps appProps;

//create contact:
	@PostMapping(value="/",consumes="application/json")
	public ResponseEntity<String> createContact(@Valid @RequestBody Contacts contacts){
		boolean createContact = contactService.createContact(contacts);
		Map<String,String> message = appProps.getMessage();
		
		return new ResponseEntity<String>(message.get(AppConstant.Contact_Success),HttpStatus.CREATED);
		}
	
//update contact:
	@PutMapping(value="/{contactId}",consumes="application/json")
	public ResponseEntity<String> updateContact(@Valid @RequestBody Contacts contacts,@PathVariable Integer contactId){
		Contacts updateContact = contactService.updateContact(contacts, contactId);
		Map<String,String> message = appProps.getMessage();
		
		return new ResponseEntity<String>(message.get(AppConstant.Contact_Update),HttpStatus.OK);
		}

//get all contacts:
	@GetMapping(value="/")
	public ResponseEntity<List<Contacts>> getAllContact(){
		List<Contacts> allContact = contactService.getAllContact();
		
		return new ResponseEntity<List<Contacts>>(allContact,HttpStatus.OK);
		}
	
//get contact by id:
	@GetMapping(value="/{contactId}")
	public ResponseEntity<Contacts> getContactById(@PathVariable Integer contactId){
		Contacts contacts = contactService.getContactById(contactId);
		
		return new ResponseEntity<Contacts>(contacts,HttpStatus.OK);
		} 
	
//delete contact:
	@DeleteMapping(value="/hard/{contactId}")
	public ResponseEntity<String> hardDeleteContact(@PathVariable Integer contactId){
		contactService.hardDeleteContact(contactId);
		Map<String,String> message = appProps.getMessage();
		
		return new ResponseEntity<String>(message.get(AppConstant.Contact_Delete),HttpStatus.OK);
		}
	
	@DeleteMapping(value="/soft/{contactId}")
	public ResponseEntity<String> softDeleteContact(@PathVariable Integer contactId){
		contactService.softDeleteContact(contactId);
		Map<String,String> message = appProps.getMessage();
		return new ResponseEntity<String>(message.get(AppConstant.Contact_Delete),HttpStatus.OK);
		}
}





















