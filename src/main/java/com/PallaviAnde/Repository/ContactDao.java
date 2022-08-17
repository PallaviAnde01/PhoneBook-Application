package com.PallaviAnde.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.PallaviAnde.Model.Contacts;

public interface ContactDao extends JpaRepository<Contacts,Integer>{

}
