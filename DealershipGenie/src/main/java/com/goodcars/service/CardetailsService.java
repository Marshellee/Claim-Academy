package com.goodcars.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goodcars.entity.Cardetails;
import com.goodcars.repo.CardetailsRepo;

@Service
public class CardetailsService {
   
    @Autowired
    CardetailsRepo cardetailsRepo;

    public List<Cardetails> getAll(){

        return cardetailsRepo.findAll();
    }
    
    public Cardetails save (Cardetails cardetails) {
       
        return cardetailsRepo.save(cardetails);
    }

    public Cardetails findById(Integer cardetailsId){

        return cardetailsRepo.findById(cardetailsId).get();
    }

    public List <Cardetails> getByMake (String make){

        return cardetailsRepo.getByMake(make);
    }
   
}
