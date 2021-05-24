package com.onlinelibback.demo.controller;

import com.onlinelibback.demo.entity.Book;
import com.onlinelibback.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:8081")
public class BookController
{
    private final BookRepository bookRepository;

    @Autowired
    public BookController(BookRepository bookRepository)
    {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/books")
    public ResponseEntity<?> getBooks()
    {
        return new ResponseEntity<>(bookRepository.findAll(), HttpStatus.CREATED);
    }
    @GetMapping("/book/{id}")
    public Book getBook(@PathVariable Long bookId)
    {
        return bookRepository.findById(bookId)
                .orElseThrow(RuntimeException::new);
    }
//    StudentController
   @PostMapping("/book")
    public ResponseEntity createBook(@RequestBody Book book) throws URISyntaxException
    {
      Book savedBook =bookRepository.save(book);
      return ResponseEntity
              .created(new URI("/books/"+savedBook
                      .getBookId())).body(savedBook);

    }
    @PutMapping("/{id}")
    public ResponseEntity updateBook(@PathVariable Long bookId,
                                     @RequestBody Book book)
    {
        Book currentBook=bookRepository
                .findById(bookId).orElseThrow(RuntimeException::new);
        currentBook.setTitleOfbook(book.getTitleOfbook());
        currentBook.setPrice(book.getPrice());
        currentBook.setPublishedTime(book.getPublishedTime());
        currentBook.setNumOfPages(book.getNumOfPages());
//        currentBook.setBookCategories(book.getBookCategories());
        currentBook.setNameOfAuthor(book.getNameOfAuthor());
        currentBook=bookRepository.save(book);

        return ResponseEntity.ok(currentBook);
    }

    @DeleteMapping("/book")
    public ResponseEntity deleteBook(@PathVariable Long bookId)
    {
        bookRepository.deleteById(bookId);
        return ResponseEntity.ok().build();
    }
}
