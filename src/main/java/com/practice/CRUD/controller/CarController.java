package com.practice.CRUD.controller;

import com.practice.CRUD.model.Car;
import com.practice.CRUD.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/car")
public class CarController {
    @Autowired
    private CarService carService;

    @GetMapping("/{id}")
    public Car findCarById(@PathVariable Integer id){
        return carService.findById(id);
    }

    @GetMapping("/findAll")
    public List<Car> findAllCar(){
        return carService.findAll();
    }

    @PostMapping("/add")
    public Car addACar(@RequestBody Car car){
        return carService.addACar(car);
    }

    @PutMapping("/update")
    public Car updateACar(@RequestBody Car car){
        return carService.updateCar(car);
    }

    @DeleteMapping("/delete")
    public Car deleteCarById(@RequestParam Integer id){
        return carService.deleteCarById(id);
    }

    @GetMapping("/find/{make}")
    public Car findByMake(@PathVariable String make){
        return carService.getCarByMake(make);
    }

}
