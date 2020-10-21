package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.persistence.model.Book;
import com.example.demo.persistence.repo.BookRepository;

@Controller
public class BookWebController {
	
	@Autowired
    private BookRepository bookRepository;
	
	@GetMapping("/show")
    public Iterable<Book> findAll(Model model) {
        return bookRepository.findAll();
    }

}
