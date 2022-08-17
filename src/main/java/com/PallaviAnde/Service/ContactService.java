package com.PallaviAnde.Service;

import java.util.List;

import com.PallaviAnde.Model.Contacts;

public interface ContactService {

	//create contact
	public boolean createContact(Contacts contacts);
	
	//update contact
	public Contacts updateContact(Contacts contacts,Integer contactId);
	
	//get contact
	public List<Contacts> getAllContact();
	public Contacts getContactById(Integer contactId);
	
	//delete contact
	public boolean deleteContact(Integer ContactId);
}
