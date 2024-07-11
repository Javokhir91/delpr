package ru.gb.spring_demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.spring_demo.model.Book;
import ru.gb.spring_demo.service.BookService;

import java.net.URI;
import java.util.List;
import java.util.NoSuchElementException;

@Slf4j
@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable("id") Long id) {
        return bookService.getBookById(id);
    }

    @DeleteMapping("/id")
    public void deleteBook(@RequestParam Long id) {
        bookService.deleteBook(id);
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        Book createdBook = bookService.createBook(book); // создание новой книги

        // создание URI для новой книги
        URI location = URI.create("/books/" + createdBook.getId()); // преобразование строки в URI
        return ResponseEntity.created(location).body(createdBook);
    }

//
//    @PostMapping("/issue")
//    public void issueBook(@RequestBody IssueRequest request) {
//        log.info("Получен запрос на выдачу: readerId = {}, bookId = {}", request.getReaderId(), request.getBookId());
//    }

    @GetMapping
    public ResponseEntity<List<Book>> getBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable("id") Long id, @RequestBody Book book) {
        if (!id.equals(book.getId())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        Book updateBook = bookService.updateBook(book);
        return ResponseEntity.ok(updateBook);
    }

}
