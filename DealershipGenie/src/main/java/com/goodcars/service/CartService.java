package com.goodcars.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goodcars.entity.Cardetails;
import com.goodcars.entity.Cart;
import com.goodcars.repo.CartRepo;

@Service
public class CartService {
    
    @Autowired
    CartRepo cartRepo;

    public Cart addToCart(Cart cart, Cardetails cardetails){
        
        cart.getCardetails().add(cardetails);

        return cartRepo.save(cart);
    }

    public Cart save (Cart cart){

        return cartRepo.save(cart);
    }

  

    
}
