package com.shotmk.EL.web.admin;

import com.shotmk.EL.entity.Book;
import com.shotmk.EL.services.BookService;
import com.shotmk.EL.wrappers.BookFileWrapper;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/service")
public class BookController {

    private Set<String> allowedBookExtensions;

    private List<String> errorMsgs = new ArrayList<String>();

    private Integer BOOK_MAX_SIZE = 20000000;

    @Autowired
    private BookService bookService;

    public BookController() {
        this.allowedBookExtensions = new HashSet<String>();
        allowedBookExtensions.add("txt");
        allowedBookExtensions.add("rtf");
        allowedBookExtensions.add("doc");
        allowedBookExtensions.add("odt");
        allowedBookExtensions.add("pdf");

    }

    @RequestMapping(value =  "/addbook", method = RequestMethod.POST)
    public String addBook(RedirectAttributes attributes, HttpServletRequest req, @RequestParam("book") MultipartFile book, @RequestParam("image") MultipartFile image) throws ServletException {
        String title = req.getParameter("bookName");
        String author = req.getParameter("author");
        String publisher = req.getParameter("publisher");
        String description = req.getParameter("description");
        BookFileWrapper bookFileWrapper = new BookFileWrapper();
        bookUploadAndValidate(book, bookFileWrapper, attributes);
        if (bookFileWrapper.getFileName() != null) {
            byte[] aBook = bookFileWrapper.getBook();
            String extension = bookFileWrapper.getExtension();
            String filename = bookFileWrapper.getFileName();
            byte[] aImage = null;
            int size = aBook.length;
            Book newBook = new Book(title, publisher, author, description, extension, filename, aBook, aImage, size);
            bookService.addBook(newBook);
        }
        return "redirect:/admin";
    }


    private void bookUploadAndValidate(@RequestParam("book") MultipartFile book, BookFileWrapper bookFileWrapper, RedirectAttributes attributes) {
        String extension = FilenameUtils.getExtension(book.getOriginalFilename());
        if (!this.allowedBookExtensions.contains(extension)) {
            addError("Incorrect file extension - only txt, rtf, doc, odt, pdf are allowed");
            attributes.addFlashAttribute("errorMsgs", this.errorMsgs);
        } else if (book.getSize() > BOOK_MAX_SIZE) {
            addError("File is too big. File size must be less then 20Mb.");
            attributes.addFlashAttribute("errorMsgs", this.errorMsgs);
        } else {
            String filename = book.getOriginalFilename();
            byte[] aBook = new byte[0];
            try {
                aBook = book.getBytes();
            } catch (IOException e) {
                addError(e.getLocalizedMessage());
                attributes.addFlashAttribute("errorMsgs", this.errorMsgs);
            }
            bookFileWrapper.setBook(aBook);
            bookFileWrapper.setExtension(extension);
            bookFileWrapper.setFileName(filename);
        }
    }

    private void addError(String msg) {
        this.errorMsgs.add(msg);
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
