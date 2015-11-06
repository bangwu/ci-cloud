package com.cloud.ci.controller;

import com.cloud.ci.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/login")
public class LoginController {

    @RequestMapping(method = RequestMethod.GET)
    public String getLoginPage() {
        return "login";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String login(@ModelAttribute("user") User user, ModelMap model) {
        model.addAttribute("message", "Hello world!");
        return "hello";
    }
}
