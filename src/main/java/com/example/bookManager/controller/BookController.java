package com.example.bookManager.controller;

import com.example.bookManager.dto.BookDTO;
import com.example.bookManager.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    // Constructor injection
    private final BookService bookService;
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // API endpoint of getting all the books
    @GetMapping
    public ResponseEntity<List<BookDTO>> getBooks() {
        List<BookDTO> books = bookService.getAllBookDTOs();
        return ResponseEntity.ok(books);
    }

    // API endpoint of getting book by id
    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> getBookById(@PathVariable Long id) {
        BookDTO bookById  = bookService.getBookDTOById(id);
        return ResponseEntity.ok(bookById);
    }

    // API endpoint to add book given in the requestbody into DB
    @PostMapping
    public ResponseEntity<BookDTO> addBook(@RequestBody BookDTO bookDTO) {
        BookDTO savedBook = bookService.saveBookDTO(bookDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBook);
    }

    // API endpoint of update book given in the requestbody into DB
    @PutMapping("/{id}")
    public ResponseEntity<BookDTO> updateBook(@PathVariable Long id, @RequestBody BookDTO bookDTO) {
        BookDTO updatedBook = bookService.updateBookDTO(id, bookDTO);
        return ResponseEntity.ok(updatedBook);
    }

    // API endpoint of deleting the book by id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }

    // API endpoint to search book by title or author and both if given
    @GetMapping("/search")
    public ResponseEntity<List<BookDTO>> searchBooks(@RequestParam(required = false) String title,
                                                  @RequestParam(required = false) String author) {

        List<BookDTO> books = bookService.searchBookDTO(title, author);

        return ResponseEntity.ok(books);
    }
}
