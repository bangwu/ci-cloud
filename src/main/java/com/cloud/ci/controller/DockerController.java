package com.cloud.ci.controller;

import com.cloud.ci.service.DockerService;
import com.cloud.ci.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by bwu on 11/8/15.
 */
@Controller
@RequestMapping
public class DockerController {

    @Autowired
    DockerService dockerService;

    @Autowired
    UserService userService;

    @RequestMapping(value = {"/containers/{userid}"}, method = RequestMethod.POST)
    public String createContainer(@PathVariable("userid") String userId, ModelMap model){
        dockerService.create(userId);
        model.addAttribute("user", userService.findByUserId(userId));
        model.addAttribute("containers", dockerService.findAllContainers(userId));
        return "containers/index";
    }

    @RequestMapping(value = {"/containers/{userid}"}, method = RequestMethod.GET)
    public String index(@PathVariable("userid") String userId, ModelMap model){
        model.addAttribute("user", userService.findByUserId(userId));
        model.addAttribute("containers", dockerService.findAllContainers(userId));
        return "containers/index";
    }
}
