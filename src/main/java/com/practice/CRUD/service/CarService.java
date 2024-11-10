package com.practice.CRUD.service;

import com.practice.CRUD.model.Car;
import com.practice.CRUD.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public Car findById(Integer id){
        Optional<Car> dbCar = carRepository.findById(id);
        if(dbCar.isEmpty()){
            throw new RuntimeException("No such Car with ID: "+id);
        }
        return dbCar.get();
    }

    public List<Car> findAll(){
        return carRepository.findAll();
    }

    public Car addACar(Car car){
        carRepository.save(car);
        return car;
    }

    public Car updateCar(Car car){
        Optional<Car> dbCar = carRepository.findById(car.getId());
        if(dbCar.isEmpty()){
            throw new RuntimeException("No such Car of ID: "+car.getId()+" to be updated");
        }
        Car toUpdateCar = dbCar.get();
        toUpdateCar.setColor(car.getColor());
        toUpdateCar.setMake(car.getMake());
        toUpdateCar.setModel(car.getModel());
        toUpdateCar.setYear(car.getYear());
        carRepository.save(toUpdateCar);
        return toUpdateCar;
    }

    public Car deleteCarById(Integer id){
        Optional<Car> dbCar = carRepository.findById(id);
        if(dbCar.isEmpty()){
            throw new RuntimeException("No such Car with ID: "+id+" to be deleted");
        }

        carRepository.deleteById(dbCar.get().getId());
        return dbCar.get();
    }

    public Car getCarByMake(String make){
        Optional<Car> dbCar = Optional.ofNullable(carRepository.getCarByMake(make));
        if(dbCar.isEmpty()){
            throw new RuntimeException("No such MAKE found of "+make);
        }
        return dbCar.get();
    }
}
