package com.shotmk.el.web.user;

import com.shotmk.el.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/mainpage")
public class MainPageController {

    @Autowired
    private BookService bookService;

    @RequestMapping(method = RequestMethod.GET)
    public String start(Model model) {
        model.addAttribute("bookList", bookService.getBookList());
        return "mainpage";
    }

}
