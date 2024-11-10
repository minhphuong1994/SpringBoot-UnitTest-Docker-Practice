package com.practice.CRUD;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.practice.CRUD.model.Car;
import com.practice.CRUD.model.Color;
import com.practice.CRUD.service.CarService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Assertions;

//Testing FindCarById route without actually running the web server.
//The request is handled by SpringBoot MockMvc and passed to the controller.
//This way save more time and resources since we bypassed bootstrapping the server
@SpringBootTest
@AutoConfigureMockMvc
public class CarFindByIdTestWithoutRunningServerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CarService carService;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void carFindIdTest() throws Exception {

        Car car = new Car();
        car.setMake("Hyundai");
        car.setYear(2023);
        car.setModel("Venue Preferred");
        car.setColor(Color.GREEN);

        Car carAdded = carService.addACar(car);

        MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.get("/api/car/"+carAdded.getId()))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String json = result.getResponse().getContentAsString();
        Car resCar = objectMapper.readValue(json,Car.class);

        assertNotNull(resCar);

        //assert the responded Car obj has the same value as the one added
        Assertions.assertEquals(resCar.compareTo(carAdded),0);
    }
}
