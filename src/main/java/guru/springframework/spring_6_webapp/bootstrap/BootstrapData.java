package guru.springframework.spring_6_webapp.bootstrap;

import guru.springframework.spring_6_webapp.domain.Author;
import guru.springframework.spring_6_webapp.domain.Book;
import guru.springframework.spring_6_webapp.domain.Publisher;
import guru.springframework.spring_6_webapp.repositories.AuthorRepository;
import guru.springframework.spring_6_webapp.repositories.BookRepository;
import guru.springframework.spring_6_webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(final AuthorRepository authorRepository, final BookRepository bookRepository, final PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(final String... args) throws Exception {
        final Author paco = new Author();
        paco.setFirstName("Paco");
        paco.setLastName("Peluca");

        final Author juanito = new Author();
        juanito.setFirstName("Juanito");
        juanito.setLastName("Calvicie");

        final Book ddd = new Book();
        ddd.setTitle("Domain Driven Design");
        ddd.setIsbn("123456");

        final Book laberinto = new Book();
        laberinto.setTitle("Laberinto del Chinotauro");
        laberinto.setIsbn("654321");

        final Author pacoSaved = authorRepository.save(paco);
        final Author juanitoSaved = authorRepository.save(juanito);
        final Book dddSaved = bookRepository.save(ddd);
        final Book laberintoSaved = bookRepository.save(laberinto);

        pacoSaved.getBooks().add(dddSaved);
        juanitoSaved.getBooks().add(laberintoSaved);
        dddSaved.getAuthors().add(pacoSaved);
        laberintoSaved.getAuthors().add(juanitoSaved);
        
        final Publisher publisher = new Publisher();
        publisher.setPublisherName("Antonio Orozco");
        final Publisher publisherSaved = publisherRepository.save(publisher);

        ddd.setPublisher(publisherSaved);
        laberinto.setPublisher(publisherSaved);
        bookRepository.save(dddSaved);
        bookRepository.save(laberintoSaved);

        System.out.println("In Bootstrap");
        System.out.println("Author Count: " + authorRepository.count());
        System.out.println("Book Count: " + bookRepository.count());
        System.out.println("Publisher Count: " + publisherRepository.count());
    }
}
