package com.example.reactive2dbc.controller;

import com.example.reactive2dbc.ErrorResponse.ErrorResponse;
import com.example.reactive2dbc.exception.BookNotFoundException;
import com.example.reactive2dbc.model.Book;
import com.example.reactive2dbc.repository.BookRepository;
import com.example.reactive2dbc.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@WebFluxTest(controllers = BookController.class)
@AutoConfigureWebTestClient
@Slf4j
public class BookControllerTest {
    private final WebTestClient webTestClient;

    @MockBean
    private final BookService bookService;

    @MockBean
    private  BookRepository bookRepository;

    @MockBean
    ConnectionFactoryInitializer initializer;

    private final String url = "/api/books";

    @Autowired
    public BookControllerTest(WebTestClient webTestClient, BookService bookService) {
        this.webTestClient = webTestClient;
        this.bookService = bookService;
    }

    @Test
    void findBookByIdOk() {
        var book = Book.builder().id(1).title("test title 1").description("test description 1").build();
        log.info("book: {}", book);

        when(bookService.findById(book.getId())).thenReturn(Mono.just(book));

        String findBookByIdUrl = String.format("%s/%s", url, book.getId());
        log.info("url: {}", findBookByIdUrl);
        webTestClient
                .get()
                .uri(findBookByIdUrl)
                .exchange()
                .expectStatus()
                .is2xxSuccessful()
                .expectBody(Book.class)
                .consumeWith(result -> {
                    var existBook = result.getResponseBody();

                    assert existBook != null;
                    assertEquals(book.getId(), existBook.getId());
                    assertEquals(book.getTitle(), existBook.getTitle());

                });
    }

    @Test
    void findBookByIdErrorNotFound() {
        var book = Book.builder().id(3).title("test title 3").description("test description 3").build();

        when(bookService.findById(book.getId())).thenReturn(Mono.error(new BookNotFoundException(String.format("Book not found. ID: %s", book.getId()))));

        String findTodoByIdUrl = String.format("%s/%s", url, book.getId());
        webTestClient
                .get()
                .uri(findTodoByIdUrl)
                .exchange()
                .expectStatus()
                .isNotFound()
                .expectBody(ErrorResponse.class)
                .consumeWith(result -> {
                    var errorResponse = result.getResponseBody();

                    assertTrue(errorResponse.getStatusCode() != HttpStatus.OK.value());
                    assertEquals("Book not found. ID: 3", errorResponse.getMessage());
                });
    }

    @Test
    void findAllBook(){
        Book book1 = Book.builder().id(1).title("Book 1").description("Description 1").build();
        Book book2 = Book.builder().id(2).title("Book 2").description("Description 2").build();

        when(bookService.findAll()).thenReturn(Flux.just(book1, book2));
        webTestClient
                .get()
                .uri(url)
                .exchange()
                .expectStatus()
                .isOk()
                .expectBodyList(Book.class)
                .hasSize(2)
                .contains(book1, book2);

    }

}