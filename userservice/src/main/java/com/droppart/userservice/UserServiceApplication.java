package com.droppart.userservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.droppart.userservice.dao.BookRepository;
import com.droppart.userservice.model.Book;

@SpringBootApplication
@RestController
@RequestMapping("/book")
public class UserServiceApplication {
	@Autowired
	private BookRepository repository;

	@PostMapping
	public Book saveBook(@RequestBody Book book){
		return null;
	//	return repository.save(book);
	}

	@GetMapping
	public List<Book> getBooks(){
		return new ArrayList<>();
	//	return repository.findAll();
	}

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

}
