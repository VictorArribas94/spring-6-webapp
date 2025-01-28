package guru.springframework.spring_6_webapp.controllers;

import guru.springframework.spring_6_webapp.repositories.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {

    private final AuthorRepository authorService;

    public AuthorController(final AuthorRepository authorService) {
        this.authorService = authorService;
    }

    @RequestMapping("/authors")
    public String getAuthors(final Model model) {

        model.addAttribute("authors", authorService.findAll());

        return "authors";
    }
}
