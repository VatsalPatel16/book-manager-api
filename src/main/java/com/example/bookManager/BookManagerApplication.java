package com.example.bookManager;

//import com.example.bookManager.model.Book;
//import com.example.bookManager.repository.BookRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import java.time.LocalDate;
//import java.util.function.Consumer;

@SpringBootApplication
public class BookManagerApplication {

//	If I am using CommandLineRunner then I have to implement CommandLineRunner interface in the class
//	// Injection of BookRepository
//	@Autowired
//	BookRepository bookRepository;
//
//	// overriding run method given by CommandLineRunner
//	@Override
//	public void run(String... args) throws Exception {
//		// Create book instances
//		Book book1 = new Book("Atomic Habits", "James Clear", "123456789", LocalDate.of(2018, 10, 15));
//		Book book2 = new Book("Clean Code", "Robert C. Martin", "098765432", LocalDate.of(2017, 10, 1));
//
//		// save books in DB
//		bookRepository.save(book1);
//		bookRepository.save(book2);
//
//		// Print the books stored in the DB
//		System.out.println("All books in DB:");
//		bookRepository.findAll().forEach(System.out::println);
//	}

	public static void main(String[] args) {
		SpringApplication.run(BookManagerApplication.class, args);
	}

}
