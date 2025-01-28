package guru.springframework.spring_6_webapp.services;

import guru.springframework.spring_6_webapp.domain.Book;
import guru.springframework.spring_6_webapp.repositories.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImplementation implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImplementation(final BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }
}
