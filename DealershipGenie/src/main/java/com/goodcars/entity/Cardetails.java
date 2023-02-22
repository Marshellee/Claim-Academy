package com.goodcars.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table(name="cardetails")

public class Cardetails {
    
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="make")
    private String make;
    @Column(name="model")
    private String model;
    @Column(name="mileage")
    private Integer mileage;
    @Column(name="year")
    private Integer year;
    @Column(name="price")
    private Double price;
    @Column(name="description")
    private String description;
    @Column(name="image")
    private String image;
    @Column(name="date")
    LocalDate date = LocalDate.now();
   
    public Cardetails() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Double getPrice() {

        if(LocalDate.now().isAfter(date.plusDays(120))){
            return this.price*.90;
        }
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Cardetails [id=" + id + ", make=" + make + ", model=" + model + ", milage=" + mileage + ", year=" + year
                + ", price=" + price + ", description=" + description + ", image=" + image + ", date=" + date + "]";
    }

    public Cardetails save(Cardetails cardetails) {
        return null;
    }

  

}
