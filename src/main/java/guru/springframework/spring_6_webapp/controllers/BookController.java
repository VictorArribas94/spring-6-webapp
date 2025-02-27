package guru.springframework.spring_6_webapp.controllers;

import guru.springframework.spring_6_webapp.services.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    private final BookService bookService;

    public BookController(final BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping("/books")
    public String getBooks(final Model model) {

        model.addAttribute("books", bookService.findAll());

        return "books";
    }
}
