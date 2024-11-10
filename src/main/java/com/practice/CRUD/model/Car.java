package com.practice.CRUD.model;

import jakarta.persistence.*;

@Entity
@Table(name = "car_details")
public class Car implements Comparable<Car>{
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

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", color=" + color +
                ", model='" + model + '\'' +
                ", make='" + make + '\'' +
                ", year=" + year +
                '}';
    }

    @Override
    public int compareTo(Car o) {
        if(this.make.compareTo(o.getMake()) !=0){
            return this.make.compareTo(o.getMake());
        }
        else if(this.model.compareTo(o.getModel()) != 0){
            return this.model.compareTo(o.getModel());
        }
        else if(this.getYear() - o.getYear() != 0){
            return this.getYear() - o.getYear();
        }
        else if(this.color.compareTo(o.getColor()) !=0){
            return this.color.compareTo(o.getColor());
        }
        return 0;
    }

}
