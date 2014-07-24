package com.shotmk.EL.web.admin;

import com.shotmk.EL.entity.Book;
import com.shotmk.EL.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.net.URLConnection;

@Controller
@RequestMapping("/service")
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(value =  "/addbook", method = RequestMethod.POST)
    public String addBook(HttpServletRequest req, HttpServletResponse resp, @RequestParam("book") MultipartFile book, @RequestParam("image") MultipartFile image) throws IOException, ServletException {
        String title = req.getParameter("bookName");
        String author = req.getParameter("author");
        String publisher = req.getParameter("publisher");
        String description = req.getParameter("description");
        byte[] aBook = book.getBytes();
        byte[] aImage = image.getBytes();
        double size = aBook.length;
        String mimeType = getMimeType(aBook);
        Book newBook = new Book(title, publisher, author, description, mimeType, aBook, aImage, size);
        bookService.addBook(newBook);
        return "redirect:/admin";
    }

    private String getMimeType(byte[] aBook) throws IOException {
        InputStream is = new BufferedInputStream(new ByteArrayInputStream(aBook));
        String mimeType = URLConnection.guessContentTypeFromStream(is);
        is.close();
        return  mimeType;
    }

    @RequestMapping(value =  "/getbooks", method = RequestMethod.POST)
    public String getBooks() {
        return "redirect:/index";
    }

    @RequestMapping(value =  "/deletebook/{bookid}", method = RequestMethod.POST)
    public String deleteBook(@PathVariable("bookId") int id) {
        Book book = bookService.getBook(id);
        bookService.deleteBook(book);
        return "redirect:/index";
    }




}
