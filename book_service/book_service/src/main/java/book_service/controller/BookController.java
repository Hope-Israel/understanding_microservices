package book_service.controller;

import book_service.entity.Book;
import book_service.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping("/book")
    public ResponseEntity<String> add(@RequestBody Book book) {
        if (bookService.addBook(book)) {
            return ResponseEntity.ok("Book created.");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error creating book.");
        }

    }

    @GetMapping("/book")
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        return ResponseEntity.ok(books);
    }

}
