package com.shotmk.el.web.user;

import com.shotmk.el.entity.Book;
import com.shotmk.el.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/mainpage")
public class MainPageController {

    @Autowired
    private BookService bookService;

    @RequestMapping(method = RequestMethod.GET)
    public void start(Model model) {
        getBookPage(1, model);
    }

    @RequestMapping(value = "/{pageNumber}", method = RequestMethod.GET)
    public String getBookPage(@PathVariable Integer pageNumber, Model model) {
        Page<Book> page = bookService.getBookPage(pageNumber);

        int current = page.getNumber() + 1;
        int begin = Math.max(1, current - 5);
        int end = Math.min(begin + 10, page.getTotalPages());

        model.addAttribute("page", page);
        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);
        model.addAttribute("currentIndex", current);
        model.addAttribute("bookList", page.getContent());

        return "mainpage";
    }

    @RequestMapping(method = RequestMethod.POST)
    public void startPost(Model model) {
        start(model);
    }

}
