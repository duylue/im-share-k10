package com.imShare.controller.basecontroller;

import com.imShare.model.User;
import com.imShare.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/")
public class BaseController {
    private UserService userService;
    @GetMapping("/homepage")
    public ModelAndView home(){
        return new ModelAndView("homepage");
    }
    @GetMapping("/login")
    public ModelAndView login(){
        return new ModelAndView("login");
    }



    @GetMapping("/create-user")
    public ModelAndView createuser() {
        User user = new User();
        ModelAndView modelAndView = new ModelAndView("user/create-user");
        modelAndView.addObject("user", user);
        return modelAndView;
    }



    @PostMapping("/user/save")
    public ModelAndView save(@ModelAttribute User user) {
        userService.save(user);
        ModelAndView modelAndView = new ModelAndView("redirect:/login");
        return modelAndView;
    }







}
