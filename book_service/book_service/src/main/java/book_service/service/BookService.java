package book_service.service;

import book_service.entity.Book;
import book_service.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public boolean addBook(Book book) {
        bookRepository.save(book);
        return true;
    }
}
