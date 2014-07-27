package com.shotmk.el.web.user;

import com.shotmk.el.entity.*;
import com.shotmk.el.services.*;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

@Controller
@RequestMapping("/book")
public class UserBookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private UserService userService;

    @Autowired
    private TagService tagService;

    @Autowired
    private RateService rateService;


    @RequestMapping("/show/{bookId}")
    public String start(@PathVariable("bookId") Integer bookId, Model model) {
        Book book = bookService.getBook(bookId);
        model.addAttribute("book", book);
        model.addAttribute("commentService", commentService);
        return "bookpage";

    }


    @RequestMapping("/download/{bookId}")
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

    @RequestMapping(value = "/addcomment", method = RequestMethod.POST)
    public String addComment(HttpServletRequest request) {
        Book book = bookService.getBook(Integer.valueOf(request.getParameter("bookId")));
        User user = userService.getUser(request.getParameter("user"));
        Comment parent = commentService.getComment(Integer.valueOf(request.getParameter("parentId")));
        String commentString = request.getParameter("comment");
        Comment comment = new Comment(parent, book, user, commentString);
        commentService.addComment(comment);
        return "redirect:/book/show/" + book.getId();
    }

    @RequestMapping("/rate/{increment}")
    public String rate(HttpServletRequest request, @PathVariable("increment") String increment) {
        Book book = bookService.getBook(Integer.valueOf(request.getParameter("bookId")));
        User user = userService.getUser(request.getParameter("user"));
        Rate tempRate = rateService.getExistRate(user.getLogin(), book.getId());
        if (tempRate != null) {
            return "redirect:/book/show/" + book.getId();
        } else {
            boolean incr = increment.equals("increment") ? true : false;
            rateService.addRate(new Rate(user, book, incr));
            if (incr) {
                book.incrementRate();
            } else {
                book.decrementRate();
            }
            bookService.addBook(book);
        }
        return "redirect:/book/show/" + book.getId();
    }

    @RequestMapping(value = "/findbook/name", method = RequestMethod.POST)
    public String findBookByName(HttpServletRequest request, Model model) {
        String name = request.getParameter("bookName");
        List<Book> bookList = bookService.findByName(name);
        model.addAttribute("bookList", bookList);
        return "findbookpage";
    }

    @RequestMapping(value = "/findbook/description", method = RequestMethod.POST)
    public String findBookByDescripton(HttpServletRequest request, Model model) {
        String description = request.getParameter("bookDescription");
        List<Book> bookList = bookService.findByDescription(description);
        model.addAttribute("bookList", bookList);
        return "findbookpage";
    }

    @RequestMapping(value = "/findbook/tag/{tag}", method = {RequestMethod.GET, RequestMethod.POST})
    public String findBookByTag(@PathVariable("tag") String tag, Model model) {
        Tag tTag = tagService.getTagByTagstring(tag);
        List<Book> bookList = bookService.findBooksByTag(tTag);
        model.addAttribute("bookList", bookList);
        return "findbookpage";
    }


}
