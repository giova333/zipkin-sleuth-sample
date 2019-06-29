package com.example.consumer.application;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.junit.StubRunnerRule;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasSize;

/**
 * Created by Alexander Gladun on 2019-06-29.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentsClientTest {

    @Autowired StudentsClient studentsClient;

    @Rule
    public StubRunnerRule stubRunnerRule = new StubRunnerRule()
            .downloadStub("com.example", "producer", "0.0.1-SNAPSHOT")
            .withPort(8080)
            .stubsMode(StubRunnerProperties.StubsMode.LOCAL);

    @Test
    public void shouldReturnDeanAndSamAccordingToContract() {
        List<Student> students = studentsClient.getStudents();

        assertThat(students, hasSize(2));
        assertThat(students, contains(new Student("Dean"), new Student("Sam")));
    }

}