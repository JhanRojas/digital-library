package com.diglib.controller;

import com.diglib.models.BookModel;
import com.diglib.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping
    public List<BookModel> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public BookModel getBookById(@PathVariable Long id) {
        return bookService.getBookById(id).orElseThrow();
    }

    @PostMapping
    public BookModel createBook(@RequestBody BookModel bookModel) {
        return bookService.saveBook(bookModel);
    }

    @PutMapping("/{id}")
    public BookModel updateBook(@PathVariable Long id, @RequestBody BookModel bookModel) {
        return bookService.updateBook(id, bookModel);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }
}
