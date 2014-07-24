package com.shotmk.EL.web.admin;

import com.shotmk.EL.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/admin")
public class AdminPageController {

    @Autowired
    BookService bookService;

    @RequestMapping(method = RequestMethod.GET)
    public void start(Model model) {
        postStart(model);
    }

    @RequestMapping(method = RequestMethod.POST)
    public String postStart(Model model) {
        model.addAttribute("bookList", bookService.getBookList());
        return "admin";
    }

}
