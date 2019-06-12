package ru.maltsev.springapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.maltsev.springapp.repos.AuthorRepo;

@Controller
public class AuthorController {

    private AuthorRepo authorRepo;

    public AuthorController(AuthorRepo authorRepo) {
        this.authorRepo = authorRepo;
    }

    @RequestMapping("/authors")
    public String getAuthor(Model model) {

        model.addAttribute("authors", authorRepo.findAll());

        return "authors";
    }
}
