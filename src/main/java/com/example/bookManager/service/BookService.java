package com.example.bookManager.service;

import com.example.bookManager.dto.BookDTO;
import com.example.bookManager.exception.BookNotFoundException;
import com.example.bookManager.model.Book;
import com.example.bookManager.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    // Constructor Injection
    private final BookRepository bookRepository;
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Getting all the books (read operation)
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(Long id) {
        // Finding the book by id and if not found then it will throw custom runtime exception
        return bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book not found with id: " + id));
    }

    // Saving the book in DB (create operation)
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    // Updating the book in DB (update operation)
    public Book updateBook(Long id, Book updatedBook) {
        Book existingBook = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book not found with id: " + id));

        existingBook.setTitle(updatedBook.getTitle());
        existingBook.setAuthor(updatedBook.getAuthor());
        existingBook.setIsbn(updatedBook.getIsbn());
        existingBook.setPublishedDate(updatedBook.getPublishedDate());

        return bookRepository.save(existingBook);
    }

    // Deleting the book from DB (delete operation)
    public void deleteBook(Long id) {

        if(!bookRepository.existsById(id)) {
            throw new BookNotFoundException("Book not found with id: " + id);
        }

        bookRepository.deleteById(id);
    }

    // Search the book by title or author or both if given (search operation)
    public List<Book> searchBooks(String title, String author) {

        if(title == null && author == null) {
            throw new IllegalArgumentException("At least one search parameter (title or author) must be provided.");
        }

        List<Book> books;
        if(title != null && author != null) {
            books = bookRepository.findByTitleContainingIgnoreCaseAndAuthorContainingIgnoreCase(title, author);
        } else if (title != null) {
            books = bookRepository.findByTitleContainingIgnoreCase(title);
        } else {
            books = bookRepository.findByAuthorContainingIgnoreCase(author);
        }

        if(books.isEmpty()) {
            throw new BookNotFoundException("No books found matching your search criteria.");
        }

        return books;
    }

    // convert the bookDTO into book entity
    public Book convertToEntity(BookDTO bookDTO) {
        Book book = new Book();
        book.setTitle(bookDTO.getTitle());
        book.setAuthor(bookDTO.getAuthor());
        book.setIsbn(bookDTO.getIsbn());
        book.setPublishedDate(bookDTO.getPublishedDate());

        return book;
    }

    // convert book into bookDTO
    public BookDTO convertToDTO(Book book) {
        return new BookDTO(
                book.getTitle(),
                book.getAuthor(),
                book.getIsbn(),
                book.getPublishedDate()
        );
    }

    // DTO methods for controller (these methods will be used in controller to decouple entity from controller)

    public List<BookDTO> getAllBookDTOs() {
        // This code is right but another one is more clean and using stream
        // List<Book> books = getAllBooks();
        // List<BookDTO> bookDTOs = new ArrayList<>();
        // for(Book book : books) {
        //     bookDTOs.add(convertToDTO(book));
        // }

        // return bookDTOs;

        return getAllBooks()
                .stream()
                .map(this::convertToDTO)
                .toList();
    }

    public BookDTO getBookDTOById(Long id) {
        Book book = getBookById(id);

        return convertToDTO(book);
    }

    public BookDTO saveBookDTO(BookDTO bookDTO) {
        Book book = convertToEntity(bookDTO);

        Book savedBook = saveBook(book);

        return convertToDTO(savedBook);
    }

    public BookDTO updateBookDTO(Long id, BookDTO bookDTO) {
        Book book = convertToEntity(bookDTO);

        Book updatedBook = updateBook(id, book);

        return convertToDTO(updatedBook);
    }

    public List<BookDTO> searchBookDTO(String title, String author) {
        return searchBooks(title, author)
                .stream()
                .map(this::convertToDTO)
                .toList();
    }
}
