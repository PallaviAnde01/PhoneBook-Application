package com.PallaviAnde.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PallaviAnde.Exception.ResourceNotFoundException;
import com.PallaviAnde.Model.Contacts;
import com.PallaviAnde.Repository.ContactDao;

@Service
public class ContactServiceImpl implements ContactService {
	
	@Autowired
	private ContactDao contactDao;

//create contact
	@Override
	public boolean createContact(Contacts contacts) {
		Contacts contact = contactDao.save(contacts);

		return true;
	}

//update contact
	@Override
	public Contacts updateContact(Contacts contacts, Integer contactId) {
		 Contacts contact = contactDao.findById(contactId).orElseThrow(()->new ResourceNotFoundException("Contact","contact id",contactId));
		
			contact.setContactName(contacts.getContactName());
			contact.setContactNumber(contacts.getContactNumber());
			contact.setContactEmail(contacts.getContactEmail());
			contact.setActiveSwitch(contacts.getActiveSwitch());
			Contacts updateContact = contactDao.save(contact);
			
			return updateContact;
		}

//get contact	
	@Override
	public List<Contacts> getAllContact() {
		List<Contacts> contacts = contactDao.findAll();
		
		return contacts;
	}

	@Override
	public Contacts getContactById(Integer contactId) {
		Contacts contacts = contactDao.findById(contactId).orElseThrow(()->new ResourceNotFoundException("Contact","contact id",contactId));
		return contacts;
	}

//delete contact
	//Hard Delete:
	@Override
	public boolean hardDeleteContact(Integer contactId) {
		Contacts contacts = contactDao.findById(contactId).orElseThrow(()->new ResourceNotFoundException("Contact","contact id",contactId));
		contactDao.deleteById(contactId);
		return true;
	}

	//Soft Delete:
	@Override
	public boolean softDeleteContact(Integer contactId) {
		Contacts contacts = contactDao.findById(contactId).orElseThrow(()->new ResourceNotFoundException("Contact","contact id",contactId));
		contacts.setActiveSwitch('N');
		Contacts softDelete = contactDao.save(contacts);
		return true;
	}

}
