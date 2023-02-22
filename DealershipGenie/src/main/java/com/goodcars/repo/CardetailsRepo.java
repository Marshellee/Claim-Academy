package com.goodcars.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.goodcars.entity.Cardetails;

@Repository
public interface CardetailsRepo extends JpaRepository<Cardetails, Integer> {
    
    @Query(value = "select * from cardetails where make = ?1", nativeQuery = true)
    public List <Cardetails> getByMake (String make);

    
}
