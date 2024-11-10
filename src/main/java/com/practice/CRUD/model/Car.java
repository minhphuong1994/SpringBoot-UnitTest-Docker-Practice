package com.practice.CRUD.model;

import jakarta.persistence.*;

@Entity
@Table(name = "car_details")
public class Car{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Color color;
    private String model;
    private String make;
    private int year;

    public int getId() {
        return id;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
