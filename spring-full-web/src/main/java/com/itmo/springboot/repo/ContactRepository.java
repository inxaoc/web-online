package com.itmo.springboot.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.itmo.springboot.web.model.Contact;

public interface ContactRepository extends CrudRepository<Contact, Long>{
	List<Contact> findByLastName(String lastName);
}
