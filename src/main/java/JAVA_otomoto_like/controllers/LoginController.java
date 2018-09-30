package JAVA_otomoto_like.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {


    @GetMapping(value = "/login")
    public String login(Model model, String error, String logout, RedirectAttributes ra) {

        return "login";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/";
    }

//    @GetMapping("/loginsuccess")
//    public String loginSuccess(){
//        try {
//            wait(5);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        return "redirect:/";
//    }
//
//    @GetMapping("/loginfailure")
//    public String loginFailure(){
//        try {
//            wait(5);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        return "redirect:/error";
//    }
}
