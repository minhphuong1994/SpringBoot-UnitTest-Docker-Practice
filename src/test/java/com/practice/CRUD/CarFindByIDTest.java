package com.practice.CRUD;

import com.practice.CRUD.model.Car;
import com.practice.CRUD.model.Color;
import com.practice.CRUD.service.CarService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

//Testing FindCarById route, this test will boostrap the server everytime running
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CarFindByIDTest {
    @LocalServerPort
    private int port; //store the RANDOM_PORT created by the WebEnv in SpringBootTest to use later

    @Autowired
    private TestRestTemplate restTemplate; //testing tool to perform request to the api

    @Autowired
    private CarService carService;

    @Test
    void findCarByIdShouldReturnACar(){
        Car car = new Car();
        car.setMake("Hyundai");
        car.setYear(2023);
        car.setModel("Venue Preferred");
        car.setColor(Color.GREEN);

        Car carAdded = carService.addACar(car);

        Assertions.assertThat(this.restTemplate
                .getForObject("http://localhost:"+ port +"/api/car/"+carAdded.getId(),Car.class))
                .isEqualByComparingTo(car);

    }
}
