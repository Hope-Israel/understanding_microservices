package book_service.service;

import book_service.entity.Book;
import book_service.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public boolean addBook(Book book) {
        bookRepository.save(book);
        return true;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book findBookByTitle(String title) {
        Book book = bookRepository.findByTitle(title);
        return book;
    }
}
