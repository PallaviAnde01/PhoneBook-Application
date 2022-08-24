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

	@Override
	public boolean createContact(Contacts contacts) {
		Contacts contact = contactDao.save(contacts);

		return true;
	}

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

	@Override
	public boolean deleteContact(Integer ContactId) {
		// TODO Auto-generated method stub
		return false;
	}

}
