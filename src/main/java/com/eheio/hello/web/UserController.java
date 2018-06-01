package com.eheio.hello.web;

import com.eheio.hello.model.UserInfo;
import com.eheio.hello.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
class UserController {
    @Autowired
    private IUserService userService;
    @Autowired
    private UserInfo userInfo;
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView registerForm() {
        ModelAndView mav = new ModelAndView("register");
        mav.addObject("user", userInfo);
        return mav;
    }
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@ModelAttribute("user") UserInfo user, @RequestParam String role) {
        org.springframework.security.crypto.password.PasswordEncoder encoder
                = new org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder();
        String passwd = encoder.encode(user.getPassword());
        user.setPassword(passwd);
        user.setEnabled((byte) 1);
        user.setRole(role);
        userService.register(user);
        return "login";
    }
}
