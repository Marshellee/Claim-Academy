package com.goodcars.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.goodcars.entity.Account;
import com.goodcars.entity.Cardetails;
import com.goodcars.service.AccountService;
import com.goodcars.service.CardetailsService;


@Controller
public class CardetailsController {
   
    @Autowired
    AccountService accountService;

    @Autowired
    CardetailsService cardetailsService;

    @GetMapping("/showme")
    public String showme (Model model, HttpSession session){
        String email = (String) session.getAttribute("email");

        if(email != null){
            Account signedin = accountService.getByEmail(email);

            List<Cardetails> cardetails = cardetailsService.getAll();
            
            model.addAttribute("account", signedin);

            model.addAttribute("cardetails", cardetails);

            return "showme";
        }
        else {
        return "showme";
        }
    } 

    @GetMapping("/showme/{make}")
    public String carsmake (Model model, HttpSession session, @PathVariable String make){
        
        String email = (String) session.getAttribute("email");

        Account loggedin = accountService.getByEmail(email);

        List <Cardetails> cardetails = cardetailsService.getByMake(make);

        System.out.println(cardetails);

        model.addAttribute("account", loggedin);

        model.addAttribute("cardetails", cardetails);

        return "showme";
    }
}
