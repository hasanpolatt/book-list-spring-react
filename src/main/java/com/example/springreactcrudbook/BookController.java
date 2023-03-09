package com.example.springreactcrudbook;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable Long id) {
        return bookRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @PostMapping
    public ResponseEntity createBook(@RequestBody Book book) throws URISyntaxException {
        Book saveBook = bookRepository.save(book);
        return ResponseEntity.created(new URI("/books/" + saveBook.getId())).body(saveBook);
    }

//    @PostMapping("/books")
//    public ResponseEntity<Book> postBody(@RequestBody Book book) {
//        Book persistedPerson = bookRepository.save(book);
//        return ResponseEntity.created(URI.create(String.format("/books/%s", book.getName()))).body(persistedPerson);
//    }

    @PutMapping("/{id}")
    public ResponseEntity updateBook(@PathVariable Long id, @RequestBody Book book) {
        Book updateBook = bookRepository.findById(id).orElseThrow(RuntimeException::new);
        updateBook.setName(book.getName());
        updateBook.setAuthor(book.getAuthor());

        updateBook = bookRepository.save(book);

        return ResponseEntity.ok(updateBook);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteBook(@PathVariable Long id) {
        bookRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }



}
