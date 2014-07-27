package com.shotmk.el.web;

import com.shotmk.el.entity.User;
import com.shotmk.el.entity.enums.UserRoleEnum;
import com.shotmk.el.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String start() {
        return "register";
    }

    @RequestMapping("/reguser")
    public String register(HttpServletRequest request) {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        ShaPasswordEncoder encoder = new ShaPasswordEncoder();
        String encPassword = encoder.encodePassword(password, null);
        String role = UserRoleEnum.USER.name();
        User newUser = new User(login, encPassword, role);
        userService.addUser(newUser);
        return "redirect:/";
    }

}
