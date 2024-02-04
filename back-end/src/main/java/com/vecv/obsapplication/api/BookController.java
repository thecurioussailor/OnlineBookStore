package com.vecv.obsapplication.api;

import com.vecv.obsapplication.models.Book;
import com.vecv.obsapplication.repository.BookRepository;
import com.vecv.obsapplication.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("http://localhost:3000/")
@RequestMapping("/api")
@org.springframework.web.bind.annotation.RestController
public class BookController {

    private BookRepository bookRepository;
    private ReviewRepository reviewRepository;

    @Autowired
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // retrieve all books
    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // retrieve book by id
    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);

        if (optionalBook.isPresent()){
            return ResponseEntity.ok(optionalBook.get());
        }
        else {
            return ResponseEntity.notFound().build();
        }

    }

    // create a new book
    @PostMapping("/books")
    public ResponseEntity<Book> createBook(@RequestBody Book book){

        //save the book
        Book createBook = bookRepository.save(book);

        return ResponseEntity.status(HttpStatus.CREATED).body(createBook);

    }

    // Update a book
    @PutMapping("/books")
    public ResponseEntity<Book> updateBook(@RequestBody Book book) {

        Book updatedBook = bookRepository.save(book);
        return ResponseEntity.ok(updatedBook);
    }

    // Delete a book
    @DeleteMapping("books/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {

            bookRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {

            return ResponseEntity.notFound().build();

        }
    }



}
