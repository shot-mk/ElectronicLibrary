package com.shotmk.el.web.user;

import com.shotmk.el.entity.Book;
import com.shotmk.el.services.BookService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;

@Controller
@RequestMapping("/book")
public class UserBookController {

    @Autowired
    private BookService bookService;

    @RequestMapping("/show/{bookId}")
    public String start(@PathVariable("bookId") Integer bookId, Model model) {
        Book book = bookService.getBook(bookId);
        model.addAttribute("book", book);
        return "bookpage";

    }


    @RequestMapping("/upload/{bookId}")
    public String download(@PathVariable("bookId")
                           Integer bookId, HttpServletResponse response) {

        Book book = bookService.getBook(bookId);
        try {
            response.setHeader("Content-Disposition", "attachment ;filename=\"" + book.getFilename() + "\"");
            OutputStream out = response.getOutputStream();
            response.setContentType(book.getFormat());
            IOUtils.copy(new ByteArrayInputStream(book.getBook()), out);
            out.flush();
            out.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/book/" + bookId;
    }
}
