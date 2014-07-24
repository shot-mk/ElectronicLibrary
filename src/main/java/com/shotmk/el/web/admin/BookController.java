package com.shotmk.el.web.admin;

import com.shotmk.el.entity.Book;
import com.shotmk.el.services.BookService;
import com.shotmk.el.wrappers.FileWrapper;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/service")
public class BookController {

    private Set<String> allowedBookExtensions;

    private Set<String> allowedImageExtensions;

    private List<String> errorMsgs = new ArrayList<String>();

    private Integer BOOK_MAX_SIZE = 20000000;

    private Integer IMAGE_MAX_WIDTH = 600;

    private Integer IMAGE_MAX_HEIGHT = 800;

    @Autowired
    private BookService bookService;

    public BookController() {
        this.allowedBookExtensions = new HashSet<String>();
        allowedBookExtensions.add("txt");
        allowedBookExtensions.add("rtf");
        allowedBookExtensions.add("doc");
        allowedBookExtensions.add("odt");
        allowedBookExtensions.add("pdf");
        this.allowedImageExtensions = new HashSet<String>();
        allowedImageExtensions.add("jpg");
        allowedImageExtensions.add("jpeg");
        allowedBookExtensions.add("bmp");
        allowedBookExtensions.add("png");

    }

    @RequestMapping(value =  "/addbook", method = RequestMethod.POST)
    public String addBook(RedirectAttributes attributes, HttpServletRequest req, @RequestParam("book") MultipartFile book, @RequestParam("image") MultipartFile image) throws ServletException {
        String title = req.getParameter("bookName");
        String author = req.getParameter("author");
        String publisher = req.getParameter("publisher");
        String description = req.getParameter("description");
        FileWrapper fileWrapper = new FileWrapper();
        FileWrapper imageWrapper = new FileWrapper();
        bookUploadAndValidate(book, fileWrapper, attributes);
        imageUploadAndValidate(image, imageWrapper, attributes);
        if (fileWrapper.getFileName() != null && imageWrapper.getFileName() != null) {
            byte[] aBook = fileWrapper.getFile();
            String extension = fileWrapper.getExtension();
            String filename = fileWrapper.getFileName();
            byte[] aImage = imageWrapper.getFile();
            int size = aBook.length;
            Book newBook = new Book(title, publisher, author, description, extension, filename, aBook, aImage, size);
            bookService.addBook(newBook);
            String successMessage = "Book successfully added";
            attributes.addFlashAttribute("successMsg", successMessage);
        }
        return "redirect:/admin";
    }


    private void bookUploadAndValidate(@RequestParam("book") MultipartFile book, FileWrapper bookWrapper, RedirectAttributes attributes) {
        String extension = FilenameUtils.getExtension(book.getOriginalFilename());
        if (!this.allowedBookExtensions.contains(extension)) {
            addError("Incorrect file extension - only txt, rtf, doc, odt, pdf are allowed.");
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
            bookWrapper.setFile(aBook);
            bookWrapper.setExtension(extension);
            bookWrapper.setFileName(filename);
        }
    }

    private void imageUploadAndValidate(@RequestParam("image") MultipartFile image, FileWrapper imageWrapper, RedirectAttributes attributes) {

        try {

            String extension = FilenameUtils.getExtension(image.getOriginalFilename());
            if (!this.allowedImageExtensions.contains(extension)) {
                addError("Incorrect image extension - only jpg, bmp, png are allowed.");
                attributes.addFlashAttribute("errorMsgs", this.errorMsgs);
                return;
            }
            BufferedImage src = ImageIO.read(new ByteArrayInputStream(image.getBytes()));
            int height = src.getHeight();
            int width = src.getWidth();
            if (height > IMAGE_MAX_HEIGHT || width > IMAGE_MAX_WIDTH) {
                addError("Incorrect image size. 800x600 or less is required.");
                attributes.addFlashAttribute("errorMsgs", this.errorMsgs);
            } else {
                imageWrapper.setFile(image.getBytes());
                imageWrapper.setFileName(image.getName());
                imageWrapper.setExtension(extension);
            }
        } catch (IOException e) {
            addError(e.getLocalizedMessage());
            attributes.addFlashAttribute("errorMsgs", this.errorMsgs);
        }

    }

    @RequestMapping("/image/{id}")
    public byte[] showImage(@PathVariable String id) {
        int intID = Integer.parseInt(id);
        byte[] image = bookService.getBook(intID).getBook();
        return image;
    }

    private void addError(String msg) {
        this.errorMsgs.add(msg);
    }

    @RequestMapping(value =  "/getbooks", method = RequestMethod.POST)
    public String getBooks() {
        return "redirect:/index";
    }

    @RequestMapping(value = "/deletebook", method = RequestMethod.POST)
    public String deleteBook(@RequestParam("deleteBook") int id) {
        Book book = bookService.getBook(id);
        bookService.deleteBook(book);
        return "redirect:/admin";
    }




}
