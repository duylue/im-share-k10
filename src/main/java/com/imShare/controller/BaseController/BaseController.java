package com.imShare.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class BaseController {
    @GetMapping("/index")
    public ModelAndView home(){
        return new ModelAndView("user/homepage");
    }
    @GetMapping("/user")
    public ModelAndView user(Model model, @RequestParam("id") int uviewid){
        model.addAttribute("uviewid", uviewid);
        return new ModelAndView("user/userpage");
    }
    @GetMapping("/user/setting")
    public ModelAndView userSetting(){
        return new ModelAndView("user/usersetting");
    }
    @GetMapping("/admin")
    public ModelAndView admin(){
        return new ModelAndView("admin/dashboard");
    }
    @GetMapping("/login")
    public ModelAndView login(){
        return new ModelAndView("/common/login");
    }
    @GetMapping("/register")
    public ModelAndView register(){
        return new ModelAndView("/user/create-user");
    }
    @GetMapping("/error-fob")
    public ModelAndView error403(){
        return new ModelAndView("/common/error404page");
    }

}
