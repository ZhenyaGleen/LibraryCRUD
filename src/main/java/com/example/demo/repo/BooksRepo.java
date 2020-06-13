package com.example.demo.repo;

import com.example.demo.model.Books;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksRepo extends CrudRepository<Books,Long> {
}
