package com.cloud.ci.controller;

import com.cloud.ci.model.Container;
import com.cloud.ci.model.User;
import com.cloud.ci.service.DockerService;
import com.cloud.ci.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping
public class LoginController {

    @Autowired
    UserService userService;

    @Autowired
    DockerService dockerService;

    @RequestMapping(method = RequestMethod.GET, value = {"/login"})
    public String getLoginPage() {
        return "login";
    }

    @RequestMapping(method = RequestMethod.POST, value = {"/login"})
    public String login(@ModelAttribute("user") User user, ModelMap model) {
        boolean isExit = userService.findUser(user);
        User user1 = userService.findUserByName(user.getUsername());
        if (isExit) {
            model.addAttribute("user", user1);
            List<Container> containers = dockerService.findAllContainers(user1.getId());
            model.addAttribute("containers", containers);
            model.addAttribute("message", "login success");
            return "containers/index";
        } else {
            model.addAttribute("message", "username or password is correct");
            return "login";
        }

    }

    @RequestMapping(method = RequestMethod.GET, value = {"/signup"})
    public String getSignUpPage(){
        return "signup";
    }

    @RequestMapping(method = RequestMethod.POST, value = {"/signup"})
    public String signup(@ModelAttribute("user") User user, ModelMap model) {
        boolean isSaved = userService.save(user);
        if(isSaved){
            model.addAttribute("message", "sign up success");
            return "login";
        }else{
            model.addAttribute("message", "sign up correct");
            return "signup";
        }

    }
}
