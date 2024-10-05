package com.diglib.services;

import com.diglib.models.BookModel;
import com.diglib.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public List<BookModel> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<BookModel> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    public BookModel saveBook(BookModel bookModel) {
        return bookRepository.save(bookModel);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    public BookModel updateBook(Long id, BookModel bookModel) {
        BookModel book = bookRepository.findById(id).orElseThrow();
        book.setTitle(bookModel.getTitle());
        book.setSynopsis(bookModel.getSynopsis());
        book.setAuthor(bookModel.getAuthor());
        book.setPublisher(bookModel.getPublisher());
        book.setPublishYear(bookModel.getPublishYear());
        book.setPrice(bookModel.getPrice());
        book.setRating(bookModel.getRating());
        book.setImageURL(bookModel.getImageURL());
        return bookRepository.save(book);
    }
}
