package com.example.demo.controller;


import com.example.demo.model.Books;
import com.example.demo.repo.BooksRepo;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/api/library")
public class BooksController {

    BooksRepo booksRepo;

    public BooksController(BooksRepo booksRepo) {
        this.booksRepo = booksRepo;
    }
    @GetMapping
    public Iterable<Books> getAllBooks(){
        return booksRepo.findAll();
    }
    @GetMapping("/{id}")
    public Optional<Books> getElementById(@PathVariable Long id){
        return booksRepo.findById(id);
    }
    @PostMapping
    public Books createElement(@RequestBody Books books){
        return booksRepo.save(books);
    }
    @PutMapping("/{id}")
    public Books updateElementBooks(@RequestBody Books books,@PathVariable Long id){
        Books books1 = booksRepo.findById(id).get();
        books1.setName(books.getName());
        books1.setLength(books.getLength());
        books1.setWhere01(books.getWhere01());
        return booksRepo.save(books);
    }
    @DeleteMapping("/{id}")
    public void deleteElement(@PathVariable Long id){
        System.out.println("delete element");
        booksRepo.deleteById(id);

    }
    
}
