package com.example.producer.application;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Alexander Gladun on 2019-06-28.
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
class StudentController {

    private final StudentService service;

    @GetMapping
    List<Student> students() {
        return service.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    void add(@RequestParam String name) {
        service.addStudent(new Student(name));
    }

}
