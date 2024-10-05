package com.diglib.controller;

import com.diglib.models.BookModel;
import com.diglib.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    BookService bookService;

    @RequestMapping("/")
    public String index(Model model) {
        List<BookModel> books = this.bookService.getAllBooks();
        model.addAttribute("books", books);
        return "index";
    }

    @RequestMapping("/product")
    public String product() {
        return "product";
    }
}
