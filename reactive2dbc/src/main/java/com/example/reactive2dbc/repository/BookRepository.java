package com.example.reactive2dbc.repository;

import com.example.reactive2dbc.model.Book;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface BookRepository extends R2dbcRepository <Book, Integer> {
    Flux<Book> findByTitleContaining(String title);

    Flux<Book> findByPublished(boolean isPublished);
}
