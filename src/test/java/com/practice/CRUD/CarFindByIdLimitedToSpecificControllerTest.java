package com.practice.CRUD;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.practice.CRUD.controller.CarController;
import com.practice.CRUD.model.Car;
import com.practice.CRUD.model.Color;
import com.practice.CRUD.service.CarService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.mockito.Mockito.when;

//This way of test will not require to run web server, hence save some time and resources
// Test web layer of CarController findById route by mocking carController.findById()
//This test to learn how to check if route is up and return something without checking the service of the route
@WebMvcTest(CarController.class)
public class CarFindByIdLimitedToSpecificControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CarService carService;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void testFindCarByIdWithACarObjCreatedByMockCarService() throws Exception {
        Car car = new Car();
        car.setMake("Hyundai");
        car.setYear(2023);
        car.setModel("Venue Preferred");
        car.setColor(Color.GREEN);

        when(carService.findById(1)).thenReturn(car);

        MvcResult result = this.mockMvc.perform(get("/api/car/1")).andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        String json = result.getResponse().getContentAsString();
        Car resCar = objectMapper.readValue(json,Car.class);

        assertNotNull(resCar);

        //assert the responded Car obj has the same value as the one added
        Assertions.assertEquals(resCar.compareTo(car),0);
    }

}
