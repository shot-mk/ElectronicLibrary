package com.shotmk.el.web;

import com.shotmk.el.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ImageController {

    @Autowired
    private BookService bookService;

    @RequestMapping("/image/{id}")
    public
    @ResponseBody
    byte[] showImage(@PathVariable String id) {
        int intID = Integer.parseInt(id);
        byte[] image = bookService.getBook(intID).getImage();
        return image;
    }
}
