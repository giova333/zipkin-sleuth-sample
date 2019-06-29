package com.example.consumer.application;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * Created by Alexander Gladun on 2019-06-29.
 */

@FeignClient(name = "studentsClient", url = "http://localhost:8080")
public interface StudentsClient {

    @GetMapping("/students")
    List<Student> getStudents();
}
