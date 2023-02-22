package com.goodcars.controller;

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
import com.goodcars.service.CartService;

@Controller
public class CartController {
    
    @Autowired
    AccountService accountService;

    @Autowired 
    CardetailsService cardetailsService;

    @Autowired
    CartService cartService;

    @GetMapping("/cart/{cardetailsId}")
    public String addToCart (@PathVariable Integer cardetailsId, HttpSession session, Model model){
        
        String email = (String) session.getAttribute("email");

        if(email != null){
            Account loggedin = accountService.getByEmail(email);

            Cardetails cardetails = cardetailsService.findById(cardetailsId);

            cartService.addToCart(loggedin.getCart(), cardetails);

            model.addAttribute("account", loggedin);

            return "cart";
        }

        return "showme";
    }

    @GetMapping("/cart")
    public String addToCart(HttpSession session, Model model){

        String email = (String) session.getAttribute("email");

        if (email != null){
            Account loggedin = accountService.getByEmail(email);

            model.addAttribute("account", loggedin);

            return "cart";

        }

        return "home";
    }
    
    
    
    }
