package com.example.producer.application;

import com.example.producer.ProducerApplication;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

/**
 * Created by Alexander Gladun on 2019-06-29.
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProducerApplication.class)
public class StudentBase {

    @Autowired StudentController controller;
    @MockBean  StudentService service;

    @Before
    public void setUp() {
        RestAssuredMockMvc.standaloneSetup(controller);
        Mockito.when(service.getAll()).thenReturn(
                Arrays.asList(
                        new Student("Dean"),
                        new Student("Sam")
                ));
    }
}
