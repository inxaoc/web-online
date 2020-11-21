package com.itmo.springboot.web.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.itmo.springboot.repo.ContactRepository;
import com.itmo.springboot.web.model.Contact;

@Controller
public class ContactController {
	
	@Autowired
	private ContactRepository contactRepository;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		// Date - dd/MM/yyyy
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, false));
	}

	
	private String getLoggedInUserName(ModelMap model) {
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		
		if (principal instanceof UserDetails) {
			return ((UserDetails) principal).getUsername();
		}
		
		return principal.toString();
	}
	
	@RequestMapping (value = "/list", method = RequestMethod.GET)
	public String showContacts(ModelMap model) {
		
		model.put("contacts", contactRepository.findAll());
		
		return "list";
		
	}
	
	@RequestMapping (value = "/add-contact", method = RequestMethod.GET)
	public String showAddContactPage (ModelMap model) {
		model.addAttribute("contact", new Contact("Ivan", "Ivanov", "email@email.com", new Date(), true));
		return "contact";
	}
	
	@RequestMapping(value = "/delete-contact", method = RequestMethod.GET)
	public String delete(@RequestParam long id) {

		contactRepository.deleteById(id);
		
		return "redirect:/list";
	}

	@RequestMapping(value = "/update-contact", method = RequestMethod.GET)
	public String showUpdatePage(@RequestParam long id, ModelMap model) {
		model.put("contact", contactRepository.findById(id));
		return "contact";
	}

	@RequestMapping(value = "/update-contact", method = RequestMethod.POST)
	public String updateContact(ModelMap model, @Validated Contact contact,
			BindingResult result) {

		if (result.hasErrors()) {
			return "contact";
		}

		contactRepository.save(contact);

		return "redirect:/list";
	}

	@RequestMapping(value = "/add-contact", method = RequestMethod.POST)
	public String addTodo(ModelMap model, @Validated Contact contact, BindingResult result) {

		if (result.hasErrors()) {
			return "contact";
		}

		contactRepository.save(contact);
		
		return "redirect:/list";
	}

}
