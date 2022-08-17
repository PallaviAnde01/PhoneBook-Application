package com.PallaviAnde.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.PallaviAnde.Model.Contacts;
import com.PallaviAnde.Repository.ContactDao;

@Service
public class ContactServiceImpl implements ContactService {
	
	private ContactDao contactDao;

	@Override
	public boolean createContact(Contacts contacts) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Contacts updateContact(Contacts contacts, Integer contactId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Contacts> getAllContact() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Contacts getContactById(Integer contactId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteContact(Integer ContactId) {
		// TODO Auto-generated method stub
		return false;
	}

}
