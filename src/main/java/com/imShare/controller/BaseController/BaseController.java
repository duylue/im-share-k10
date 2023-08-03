package com.imShare.controller.BaseController;
import com.imShare.model.User;
import com.imShare.repository.RoleRepository;
import com.imShare.repository.UserRepository;
import com.imShare.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/")
public class BaseController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserService userService;
    @GetMapping("/index")
    public ModelAndView home(){
        return new ModelAndView("user/homepage");
    }
    @GetMapping("/user")
    public ModelAndView user(Model model, @RequestParam("id") int uviewid){
        model.addAttribute("uviewid", uviewid);
        return new ModelAndView("/user/userpage");
    }
    @GetMapping("/user/setting")
    public ModelAndView userSetting(){
        return new ModelAndView("user/u-setting");
    }
    @GetMapping("/admin")
    public ModelAndView admin(){
        return new ModelAndView("/admin/dashboard");
    }
    @GetMapping("/login")
    public ModelAndView login(){
        return new ModelAndView("/common/login");
    }
    @GetMapping("/logout")
    public ModelAndView logout(){
        return new ModelAndView("/common/login");
    }
    @GetMapping("/register")
    public ModelAndView register(){
            User user = new User();
            ModelAndView modelAndView = new ModelAndView("/user/create-user");
            modelAndView.addObject("user", user);
            return modelAndView;
    }
    @PostMapping("/register")
    public ModelAndView save(@ModelAttribute User user) {
        userService.addUser(user);
        ModelAndView modelAndView = new ModelAndView("redirect:/login");
        return modelAndView;
    }
    @GetMapping("/error-fob")
    public ModelAndView errorFob(){
        return new ModelAndView("/common/error404page");
    }
}
