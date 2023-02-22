package com.goodcars.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.goodcars.entity.Account;
import com.goodcars.entity.Cardetails;
import com.goodcars.entity.Cart;
import com.goodcars.service.AccountService;
import com.goodcars.service.CardetailsService;
import com.goodcars.service.CartService;

@Controller
public class AccountController {

    @Autowired
    AccountService accountService;

    @Autowired
    CardetailsService cardetailsService;

    @Autowired
    CartService cartService;

    @GetMapping("/")
    public String home (){

        return "home";
    }

    @GetMapping("/signup")
    public String signup (Model model){

        model.addAttribute("account", new Account());
        return "signup";
    }

    @PostMapping("/signup")
    public String signup (@ModelAttribute("account") Account account, Model model, HttpSession session){
       
        Cart cart = cartService.save(new Cart());
       
        Account signedin = accountService.save(account, cart);

       System.out.println(signedin.toString());

       session.setAttribute("email", signedin.getEmail());

       model.addAttribute("account", signedin);

        return "redirect:showme";
    }

    @GetMapping("/signin")
    public String signin (Model model){

        model.addAttribute("signedup", new Account());

        return "signin";
    }

    @PostMapping("/signin")
    public String signin (@ModelAttribute Account account, Model model, HttpSession session){

        Account loggedin = accountService.login(account);

        if(loggedin == null) {
            return "redirect:signin";
        }
        
        session.setAttribute("email", loggedin.getEmail());

        if (loggedin.getAdmin()==true){
            return "redirect:admin";
        }

        model.addAttribute("account", loggedin);

        return "redirect:showme";

    }

    @GetMapping("/signout")
    public String signout(HttpSession session){

        session.removeAttribute("email");

        return "redirect:/";
    }

    @GetMapping("/profile")
    public String profile(Model model, HttpSession session){

        String email = (String) session.getAttribute("email");
        if (email == null){

            return "redirect: ";
        }

        Account account = accountService.getByEmail(email);

        if (account==null){
            return "redirect:";
        }

        model.addAttribute("account", account);

        return "profile";
    }

    @PostMapping("/profile")
    public String profile(@ModelAttribute Account account, Model model){
        
        account = accountService.update(account);

        model.addAttribute("account", account);
        
        return "profile";

    }

    @GetMapping("/admin")
    public String admin(Model model){
        model.addAttribute("cardetails", new Cardetails());
        return "admin";
    }

    @PostMapping("/admin")
    public String admin (Cardetails cardetails, Model model){
       
        Cardetails addcars = cardetailsService.save(cardetails);

        System.out.println(addcars.toString());

        model.addAttribute("cardetails", addcars);

        return "redirect: showme";

    }

    
 
}
