package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.persistence.model.Book;
import com.example.demo.persistence.repo.BookRepository;

@Controller
public class SimpleController {
    @Value("${spring.application.name}")
    String appName;
    
    @Autowired
    private BookRepository bookRepository;
 
    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("appName", appName);
        
        return "home";
    }
    @GetMapping("/greeting")
	public String greeting(@RequestParam(name="name", required=true, defaultValue="World") String name, Model model) {
		
    	model.addAttribute("name", name);
		
    	return "home";
	}
}
