package com.example.consumer.application;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Alexander Gladun on 2019-06-28.
 */

@Component
@RequiredArgsConstructor
@Slf4j
public class EventListener {

    private final StudentsClient studentsClient;

    @StreamListener(StudentChannel.INPUT)
    public void listen(Student student) {
        log.info("New student added: {}", student);
        List<Student> students = studentsClient.getStudents();
        log.info("All students: {}", students);
    }
}
