package guru.springframework.spring_6_webapp.services;

import guru.springframework.spring_6_webapp.domain.Author;
import guru.springframework.spring_6_webapp.repositories.AuthorRepository;

public class AuthorServiceImplementation implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImplementation(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Iterable<Author> findAll() {

        return authorRepository.findAll();
    }
}
