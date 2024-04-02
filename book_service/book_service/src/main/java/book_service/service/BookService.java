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

    /*Adds new book to database*/
    public boolean addBook(Book book) {
        bookRepository.save(book);
        return true;
    }

    /*Gets all books from database*/
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    /*Locates book by title*/
    public Book findBookByTitle(String title) {
        Book book = bookRepository.findByTitle(title);
        return book;
    }

    /*Updates an existing book in the database*/
    public boolean updateBook(Long id, Book newBook) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()){
            Book existingBook = optionalBook.get();
            existingBook.setTitle(newBook.getTitle());
            bookRepository.save(existingBook);
            return true;
        }
        return false;
    }

    /*Delete book from database by its ID*/
    public boolean deleteBook(Long id){
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
