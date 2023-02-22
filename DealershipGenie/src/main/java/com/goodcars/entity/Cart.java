package com.goodcars.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="cart")
public class Cart {
    
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @ManyToMany
    @JoinTable(
        name="cart_cardetails",
        joinColumns={
            @JoinColumn(name="cart_id", referencedColumnName = "id")
        },
        inverseJoinColumns = {
            @JoinColumn(name="cardetails_id", referencedColumnName = "id")
        }
    )
    List<Cardetails> cardetails;

    public Cart() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Cardetails> getCardetails() {
        return cardetails;
    }

    public void setCardetails(List<Cardetails> cardetails) {
        this.cardetails = cardetails;
    }

    @Override
    public String toString() {
        return "Cart [id=" + id + ", cardetails=" + cardetails + "]";
    }

    public Double getTotal(){

        Double sum = 0.0;

        for (int i = 0; i < this.cardetails.size(); i++) {
            
            sum += this.cardetails.get(i).getPrice();
        }

        return sum;
    }
    
    
}
