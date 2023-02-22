package com.goodcars.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.goodcars.entity.Cart;

@Repository
public interface CartRepo extends JpaRepository <Cart, Integer> {
    
}
