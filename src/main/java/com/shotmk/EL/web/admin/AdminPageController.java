package com.shotmk.EL.web.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/admin")
public class AdminPageController {

    @RequestMapping(method = RequestMethod.GET)
    public String start(Model model) {
        return "admin";
    }

}
