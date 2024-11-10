package com.practice.CRUD;

import com.practice.CRUD.controller.CarController;
import static org.assertj.core.api.Assertions.assertThat; //allow to import and use static class without class path
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ControllerCreatedTest {
    @Autowired
    private CarController carController;

    //Test if the context application created the CarController
    @Test
    void contextLoads(){
        assertThat(carController).isNotNull();
    }
}
