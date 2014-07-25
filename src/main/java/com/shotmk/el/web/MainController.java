package com.shotmk.el.web;

import com.shotmk.el.entity.User;
import com.shotmk.el.entity.enums.UserRoleEnum;
import com.shotmk.el.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.PostConstruct;

@Controller
@RequestMapping("/")
public class MainController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String start(Model model) {
        return "index";
    }

    @PostConstruct
    public void postConstruct() {
        User user = userService.getUser("admin");
        if (user == null) {
            String login = "admin";
            String password = "admin";
            String role = UserRoleEnum.ADMIN.name();
            ShaPasswordEncoder encoder = new ShaPasswordEncoder();
            String encodedPassword = encoder.encodePassword(password, null);
            user = new User(login, encodedPassword, role);
            userService.addUser(user);
        }
    }

}
