package com.example.lab4.web;

import com.example.lab4.domain.Book;
import com.example.lab4.domain.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
@RequestMapping("/api/books")
public class BookController {

    private BookRepository repository;

    @Autowired
    public void setRepository(BookRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(method = RequestMethod.POST)
    public void createBook(@RequestBody Book book) {
        repository.save(book);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Book> findAllBooks() {
        return repository.findAll();
    }

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/{id}")
    public Book findBookById(@PathVariable Integer id) {

        Optional<S> one = repository.findOne(id);
        return one;
    }

    @RequestMapping(
            method = RequestMethod.DELETE,
            value = "/{id}")
    public void deleteBookWithId(@PathVariable int id) {
        repository.delete(id);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteAllBooks() {
        repository.deleteAll();
    }
}